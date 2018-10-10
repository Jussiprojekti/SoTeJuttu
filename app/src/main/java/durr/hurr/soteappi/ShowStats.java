package durr.hurr.soteappi;

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
     * Etsii textviet ja asettaa niihin tekstit DayContainerin metodeilla
     * @param savedInstanceState oletus
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_stats);

        TextView keskiSyonti = findViewById(R.id.textAvarangeKcal);
        keskiSyonti.setText(DayContainer.getInstance().getAvarangeKcal());

        TextView painonMuutos = findViewById(R.id.textPainonMuutos);
        painonMuutos.setText(DayContainer.getInstance().getPainonMuutos());

        TextView keskikulutus = findViewById(R.id.textKulutus);
        keskikulutus.setText(DayContainer.getInstance().getKeskiKulutus());

    }
}
