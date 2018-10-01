package durr.hurr.soteappi;

import java.util.ArrayList;

public class DayContainer {
    private static final DayContainer ourInstance = new DayContainer();

    private static final DayContainer dayContainer = new DayContainer();
    public ArrayList<Day> listDays;

    private DayContainer() {
        listDays = new ArrayList<>();
        //DayContainer.getInstance().listDays.add(new Day());

    }

    //Find daycontainer method
    static DayContainer getInstance() {
        return dayContainer;
    }

    public ArrayList<Day> getPresidents() {
        return listDays;
    }

    public Day getDay(int i) {
        return listDays.get(i);
    }



}
