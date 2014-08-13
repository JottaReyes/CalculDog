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

            txt_title.setTypeface(changeTypeface(PATH_ROBOTO_BOLD, 1));
            txt_result.setTypeface(changeTypeface(PATH_ROBOTO_THIN,2));
            edTxt_DogAge.setTypeface(changeTypeface(PATH_ROBOTO_THIN,2));
            btn_calculate.setTypeface(changeTypeface(PATH_ROBOTO_BOLD,1));

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

                int age = Integer.parseInt(dogAge) * 4;
                String result = Integer.toString(age);
                return result;

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
