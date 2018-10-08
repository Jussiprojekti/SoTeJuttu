package durr.hurr.soteappi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowStats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_stats);

        TextView keskiSyonti = findViewById(R.id.textAvarangeKcal);
        keskiSyonti.setText(DayContainer.getInstance().getAvarangeKcal());

        TextView painonMuutos = findViewById(R.id.textPainonMuutos);
        painonMuutos.setText(DayContainer.getInstance().getPainonMuutos());

        TextView keskikulutus = findViewById(R.id.textKeskikulutus);
        keskikulutus.setText(DayContainer.getInstance().getKeskiKulutus());

    }
}
