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
    int paino;
    int kalorit;
    String paiva;
    public String sex;
    public static final String KEY_SEX="sexKey";
    public static final String log = "SoTeAppi";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPref = getSharedPreferences(SHARED_PREF, Activity.MODE_PRIVATE);
        sex=myPref.getString(KEY_SEX, "male");
        paivaTarkistus();

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

    public void paivaTarkistus() {
        setContentView(R.layout.activity_main);
        myPref = getSharedPreferences(SHARED_PREF, Activity.MODE_PRIVATE);
        ZoneId aikaVyo = ZoneId.of("Europe/Helsinki");
        paiva = myPref.getString("paiva", LocalDate.now(aikaVyo).toString());
        kalorit = myPref.getInt("kalorit", 0);
        paino = myPref.getInt("paino", 0);
        if(!LocalDate.now(aikaVyo).toString().equals(paiva)) {
            Day tanaan = new Day(LocalDate.now(aikaVyo).toString(), 0, paino);
            TextView paivamaara = findViewById(R.id.testi);
            paivamaara.setText(LocalDate.now(aikaVyo).toString());
            DayContainer.getInstance().listDays.add(new Day(paiva, kalorit, paino));
        } else {
            Day tanaan = new Day(paiva, kalorit, paino);
        }
        TextView kaloriNaytto = findViewById(R.id.kaloriView);
        kaloriNaytto.setText(Integer.toString(kalorit));
        Log.d(log, "paivatarkistus");
    }

    public void saveData() {
        SharedPreferences.Editor editor = myPref.edit();
        editor.putString(KEY_SEX, this.sex);
        editor.putString("paiva", paiva);
        editor.putInt("kalorit", kalorit);
        editor.putInt("paino", paino);
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        paivaTarkistus();

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(log,"Paused");
        saveData();
    }

}
