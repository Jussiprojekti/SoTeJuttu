package durr.hurr.soteappi;

import java.util.ArrayList;

public class DayContainer {
    private static final DayContainer ourInstance = new DayContainer();

    private static final DayContainer dayContainer = new DayContainer();
    public ArrayList<Day> listDays;

    private DayContainer() {
        listDays = new ArrayList<>();
        listDays.add(new Day("jee", 32, 43));
        listDays.add(new Day("juu", 47, 98));
        //DayContainer.getInstance().listDays.add(new Day("jee", 32, 43));
        //DayContainer.getInstance().listDays.add(new Day("juu", 47, 98));
    }

    //Find daycontainer method
    static DayContainer getInstance() {
        return dayContainer;
    }

    public ArrayList<Day> getDaysList() {
        return listDays;
    }

    public Day getDay(int i) {
        return listDays.get(i);
    }



}
