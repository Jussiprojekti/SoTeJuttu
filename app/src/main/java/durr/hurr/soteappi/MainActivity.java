package durr.hurr.soteappi;

import android.icu.text.TimeZoneFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Benis");
        ZoneId aikaVyo = ZoneId.of("Europe/Helsinki");
        Day tanaan = new(Day(LocalDate.now(aikaVyo)));
    }

}
