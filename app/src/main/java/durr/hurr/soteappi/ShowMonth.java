package durr.hurr.soteappi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Kaikkien tallennettujen Day olioiden näyttämiseen käytetty aktiviteetti
 * @author Tommi
 */

public class ShowMonth extends AppCompatActivity {
    /**
     * Asettaa listviewen ja populoi sen ArrayAdapterilla
     * @param savedInstanceState oletus
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_month);

        //Find ListView element
        ListView lv = findViewById(R.id.listViewMonth);

        //Create adapter that handle arraylist to ListView
        ArrayAdapter<Day> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                DayContainer.getInstance().getDaysList()
        );

        //Set adapter to right element
        lv.setAdapter(adapter);
    }
}
