package durr.hurr.soteappi;

import android.util.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import static durr.hurr.soteappi.MainActivity.log;
import static durr.hurr.soteappi.MainActivity.osoite;

public class DayContainer {

    private static final DayContainer dayContainer = new DayContainer();
    public ArrayList<Day> listDays;
    private ArrayList listHolder;

    private DayContainer() {
        try {
            FileInputStream fis = new FileInputStream(osoite);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listHolder = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
            Log.d(log, "tieto luettu");
        } catch(IOException ioe){
            ioe.printStackTrace();
            Log.d(log, "rikki");
            return;
        } catch(ClassNotFoundException c){
            c.printStackTrace();
            Log.d(log, "rikki 2");
            return;
        }
        try {
            listDays = listHolder;
            Log.d(log, "Lista asetettu");
        } catch(NullPointerException nub) {
            listDays = new ArrayList<>();
            listDays.add(new Day("27-04-2018", 1720, 75));
            listDays.add(new Day("28-04-2018", 1635, 74));
            listDays.add(new Day("29-04-2018", 2030, 74));
        }
        //DayContainer.getInstance().listDays.add(new Day("jee", 32, 43));
        //DayContainer.getInstance().listDays.add(new Day("juu", 47, 98));
    }

    //Find daycontainer method
    static DayContainer getInstance() {
        return dayContainer;
    }

    public ArrayList<Day>  getDaysList() {
        return listDays;
    }

    public Day getDay(String day) {
        for(int k = 0; this.listDays.size()>k; k++) {
            Day vertaus = this.listDays.get(k);
                if(day.equals(vertaus.getPaiva())) {
                    return vertaus;
                }
            }
        return null;

    }
    public double getAvarangeKcal() {
        double kcal=0;
        for (Day currentday : listDays) {
            kcal += currentday.getKalorit();
        }
        return kcal/listDays.size();
    }

}





