package durr.hurr.soteappi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.time.LocalDate;
import java.time.ZoneId;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Benis");
        ZoneId aikaVyo = ZoneId.of("Europe/Helsinki");
        Day tanaan = new Day(LocalDate.now(aikaVyo).toString());
        TextView paivamaara = findViewById(R.id.testi);
        paivamaara.setText(LocalDate.now(aikaVyo).toString());
    }

}
