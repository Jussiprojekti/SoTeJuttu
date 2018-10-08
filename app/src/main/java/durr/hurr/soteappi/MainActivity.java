package durr.hurr.soteappi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SharedPreferences myPref;
    public static final String SHARED_PREF="agePref";
    int paino;
    public String sex;
    public Day tanaan;
    ArrayList<Day> listaHolder;
    FileOutputStream ulosVirta;
    public static final String KEY_SEX="sexKey";
    public static final String log = "SoTeAppi";
    File sailio;
    public static String osoite;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        osoite = getFilesDir().getPath() + "lista.ser";
        setContentView(R.layout.activity_main);
        myPref = getSharedPreferences(SHARED_PREF, Activity.MODE_PRIVATE);
        sex=myPref.getString(KEY_SEX, "male");
        paino = myPref.getInt("paino", 0);
    }
     public void onShowMonthButton(View view) {
        Log.d("MY_APP", "onItemClick(ShowMonthsButton)");
        //Go to ShowMonth activity
        Intent nextActivity = new Intent(MainActivity.this, ShowMonth.class);
        //nextActivity.putExtra("ListOfDays", DayContainer.getInstance().getDaysList());
        startActivity(nextActivity);
    }

    public void lisaaKaloreita(View view) {
        EditText kaloriKentta = findViewById(R.id.kaloriInput);
        String teksti2 = kaloriKentta.getText().toString();
        int lisaKalori = Integer.valueOf(teksti2);
        if(!TextUtils.isEmpty(teksti2)) {
            tanaan.setKaloreita(lisaKalori);
            Log.d(log, "lisatty kaloreita");
        }
        paivitys();
    }

    public void lisaaPaino(View view) {
        EditText painoKentta = findViewById(R.id.painoInput);
        String teksti2 = painoKentta.getText().toString();
        int lisapaino = Integer.valueOf(teksti2);
        if(!TextUtils.isEmpty(teksti2)) {
            tanaan.setPainoa(lisapaino);
            Log.d(log, "lisatty paino");
        }
        paivitys();
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
        if(DayContainer.getInstance().getDay(LocalDate.now(aikaVyo).toString()) != null) {
            String paiva = LocalDate.now(aikaVyo).toString();
            tanaan = DayContainer.getInstance().getDay(paiva);
            Log.d(log, "paiva haettu");
        } else {
            tanaan = new Day (LocalDate.now(aikaVyo).toString(), 0, paino);
            DayContainer.getInstance().getDaysList().add(tanaan);
            Log.d(log, "uusi paiva");
        }
        TextView paivamaara = findViewById(R.id.testi);
        paivamaara.setText(LocalDate.now(aikaVyo).toString());
        paivitys();
        Log.d(log, "paivatarkistus");
    }

    public void paivitys() {
        setContentView(R.layout.activity_main);
        TextView kaloriKentta = findViewById(R.id.kaloriView);
        kaloriKentta.setText(Integer.toString(tanaan.getKalorit()));
    }

    public void saveData() {
        SharedPreferences.Editor editor = myPref.edit();
        editor.putString(KEY_SEX, this.sex);
        editor.putInt("paino", tanaan.getPaino());
        sailio = new File(getFilesDir().getPath() + "lista.ser");
        try{
            String filename = getFilesDir().getPath() + "lista.ser";
            listaHolder = DayContainer.getInstance().getDaysList();
            Log.d(log, "1");
            FileOutputStream fos = null;
            ObjectOutputStream out = null;
            Log.d(log, "2");
            fos = new FileOutputStream(filename);
            Log.d(log, "3");
            out = new ObjectOutputStream(fos);
            out.writeObject(listaHolder);
            out.close();
            Log.d(log, "tieto tallennettu");
        }catch(IOException ioe){
            ioe.printStackTrace();
            Log.d(log, "rikki tallennus");
        }
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        paivaTarkistus();
        paivitys();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(log,"Paused");
        saveData();
    }

}
