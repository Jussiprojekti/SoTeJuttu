package durr.hurr.soteappi;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


/**
 * Aktiviteetti joka laskee appiin tallennetuista tiedoista yhteenvedot ja antaa ne käyttäjälle
 * paremmin ymmärrettävässä formaatissa
 * @author Tommi
 */
public class ShowStats extends AppCompatActivity {
    /**
     * Etsii textviewit ja asettaa niihin tekstit DayContainerin metodeilla
     * @param savedInstanceState oletus
     */
    SharedPreferences myPref;
    public static final String KEY_SEX="sexKey";
    public static final String SHARED_PREF="myPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_stats);
        myPref = getSharedPreferences(SHARED_PREF, Activity.MODE_PRIVATE);
        String sukupuoli=myPref.getString(KEY_SEX, "male");

        TextView keskiSyonti = findViewById(R.id.textAvarangeKcal);
        keskiSyonti.setText(DayContainer.getInstance().getAvarangeKcal());

        TextView painonMuutos = findViewById(R.id.textPainonMuutos);
        painonMuutos.setText(DayContainer.getInstance().getPainonMuutos());

        TextView keskikulutus = findViewById(R.id.textKulutus);
        keskikulutus.setText(DayContainer.getInstance().getKeskiKulutus());

        // Testataan kumpi sukupuoli on valittu ja annetaan tietoa sen mukaan
        if (sukupuoli.equals("male")) {
            TextView sexKulutus = findViewById(R.id.textSexKulutus);
            sexKulutus.setText("Miesten normaali kalorikulutus on 2200 kcal/pv");
        } else {
            TextView sexKulutus = findViewById(R.id.textSexKulutus);
            sexKulutus.setText("Naiseten normaali kalorikulutus on 2000 kcal/pv");
        }


    }
}
