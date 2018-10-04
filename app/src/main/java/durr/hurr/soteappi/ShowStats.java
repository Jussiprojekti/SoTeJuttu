package durr.hurr.soteappi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowStats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_stats);


        TextView paivamaara = findViewById(R.id.textAvarangeKcal);
        paivamaara.setText(Double.toString(DayContainer.getInstance().getAvarangeKcal()));

    }
}
