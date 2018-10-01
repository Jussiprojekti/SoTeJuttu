package durr.hurr.soteappi;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.view.View;
import android.widget.TextView;
import java.time.LocalDate;
import java.time.ZoneId;

public class MainActivity extends AppCompatActivity {

    SharedPreferences myPref;
    public static final String SHARED_PREF="agePref";
    public String sex;
    public static final String KEY_SEX="sexKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sex=myPref.getString(KEY_SEX, "male");

        myPref = getSharedPreferences(SHARED_PREF, Activity.MODE_PRIVATE);

        ZoneId aikaVyo = ZoneId.of("Europe/Helsinki");
        Day tanaan = new Day(LocalDate.now(aikaVyo).toString());
        TextView paivamaara = findViewById(R.id.testi);
        paivamaara.setText(LocalDate.now(aikaVyo).toString());

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButtonMies:
                if (checked)
                    sex="male";
                    break;
            case R.id.radioButtonNainen:
                if (checked)
                    sex="female";
                    break;
        }
    }

    public void saveData() {
        SharedPreferences.Editor editor = myPref.edit();
        editor.putString(KEY_SEX, this.sex);
        editor.commit();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("MY_APP","Paused");
        saveData();
    }



}
