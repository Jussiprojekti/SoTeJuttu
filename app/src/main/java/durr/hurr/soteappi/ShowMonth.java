package durr.hurr.soteappi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShowMonth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_month);

        ListView lv = findViewById(R.id.listViewMonth);

        //Muuntaa näkymän niin että osaa käsitellä Arraylistaa
        lv.setAdapter(new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_1,
            PresidenttiContainer.getInstance().getPresidents())
        );
    }
}
