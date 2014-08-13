package jotta.com.calculdog;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;


public class Calculator extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        Button btn_calculate;
        TextView txt_result;
        EditText edTxt_DogAge;
        TextView txt_title;

        private static final String  PATH_ROBOTO_BOLD = "fonts/Roboto-Bold.ttf";
        private static final String PATH_ROBOTO_THIN = "fonts/Roboto-Thin.ttf";
        private static final int ID_BOLD = 1;
        private static final int ID_THIN = 2;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_calculator, container, false);

            btn_calculate = (Button) rootView.findViewById(R.id.buttonCalculate);
            txt_result = (TextView) rootView.findViewById(R.id.textViewResult);
            edTxt_DogAge = (EditText) rootView.findViewById(R.id.editTextDogAge);
            txt_title = (TextView) rootView.findViewById(R.id.textViewTitle);

            txt_title.setTypeface(changeTypeface(PATH_ROBOTO_BOLD, ID_BOLD));
            txt_result.setTypeface(changeTypeface(PATH_ROBOTO_THIN,ID_THIN));
            edTxt_DogAge.setTypeface(changeTypeface(PATH_ROBOTO_THIN, ID_THIN));
            btn_calculate.setTypeface(changeTypeface(PATH_ROBOTO_BOLD,ID_BOLD));

            btn_calculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String mDogAge = edTxt_DogAge.getText().toString();

                    if(mDogAge != null || edTxt_DogAge.getText().toString().equals("")){
                        String result = calculateAge(mDogAge);
                        txt_result.setText("La edad de tu perro en años humanos es: " + result + " años");
                        edTxt_DogAge.setText("");
                    }else {
                        Toast toast = Toast.makeText(getActivity().getApplicationContext(),"Por favor introduzca la edad de su perro", LENGTH_SHORT);
                        toast.show();
                    }

                }
            });


            return rootView;
        }

        private String calculateAge(String dogAge){

            int calcAge;

            int age = Integer.parseInt(dogAge);

            switch (age){
                case 1:
                    calcAge = 13;
                    return Integer.toString(calcAge);
                case 2:
                    calcAge = 24;
                    return Integer.toString(calcAge);
                case 3:
                    calcAge = 24;
                    return Integer.toString(calcAge);
                case 4:
                    calcAge = 40;
                    return Integer.toString(calcAge);
                case 5:
                    calcAge = 42;
                    return Integer.toString(calcAge);
                case 6:
                    calcAge = 49;
                    return Integer.toString(calcAge);
                case 7:
                    calcAge = 49;
                    return Integer.toString(calcAge);
                case 8:
                    calcAge = 56;
                    return Integer.toString(calcAge);
                case 9:
                    calcAge = 63;
                    return Integer.toString(calcAge);
                case 10:
                    calcAge = 65;
                    return Integer.toString(calcAge);
                case 11:
                    calcAge = 71;
                    return Integer.toString(calcAge);
                case 12:
                    calcAge = 75;
                    return Integer.toString(calcAge);
                case 13:
                    calcAge = 80;
                    return Integer.toString(calcAge);
                case 14:
                    calcAge = 84;
                    return Integer.toString(calcAge);
                case 15:
                    calcAge = 87;
                    return Integer.toString(calcAge);
                case 16:
                    calcAge = 90;
                    return Integer.toString(calcAge);
                default:
                    calcAge = age * 4;
                    return Integer.toString(calcAge);

            }

        }

        private Typeface changeTypeface (String path, int id){

            if(id == 1){
                Typeface robotoBold = Typeface.createFromAsset(getActivity().getAssets(), path);
                return robotoBold;
            }else{
                Typeface robotoRegular = Typeface.createFromAsset(getActivity().getAssets(), path);
                return robotoRegular;
            }
        }
    }
}
