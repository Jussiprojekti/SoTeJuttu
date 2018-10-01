package durr.hurr.soteappi;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    SharedPreferences myPref;
    public static final String SHARED_PREF="agePref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myPref = getSharedPreferences(SHARED_PREF, Activity.MODE_PRIVATE);

        setContentView(R.layout.activity_main);
        //Day tanaan = new(Day(LocalDate));

        public void onRadioButtonClicked(View view) {
            // Is the button now checked?
            boolean checked = ((RadioButton) view).isChecked();

            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.radioButtonMies:
                    if (checked)
                        // Pirates are the best
                        break;
                case R.id.radioButtonNainen:
                    if (checked)
                        // Ninjas rule
                        break;
            }
        }
    }

}
