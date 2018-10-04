package durr.hurr.soteappi;

import java.util.ArrayList;

public class DayContainer {
    private static final DayContainer ourInstance = new DayContainer();

    private static final DayContainer dayContainer = new DayContainer();
    public ArrayList<Day> listDays;

    private DayContainer() {
        listDays = new ArrayList<>();
        listDays.add(new Day("27-04-2018", 1720, 75));
        listDays.add(new Day("28-04-2018", 1635, 74));
        listDays.add(new Day("29-04-2018", 2030, 74));
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

    public int getAvarange() {
        for (Day currentday : listDays) {
            currentday.getKalorit();
        }
    }


}
