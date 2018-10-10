package durr.hurr.soteappi;

import android.util.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import static durr.hurr.soteappi.MainActivity.log;
import static durr.hurr.soteappi.MainActivity.osoite;

/**
 * Singleton luokka johon tallenetaan Day olioita ja joka sisältää metodit kalorien keskikulutuksen
 * ja painon muutosten laskemiseen
 * @author Tommi
 */
public class DayContainer {

    private static final DayContainer dayContainer = new DayContainer();
    public ArrayList<Day> listDays;
    private ArrayList listHolder;


    /**
     * Kontruktori metodi Singletonin luomista varten, sisältää tietojen haun ja väliaikaisen
     * testipäivien lisäämisen
     */
    private DayContainer() {
        boolean err = false;
        //Yrittää lukea tiedoston levyltä ja pistää sen väliaikaiseen ArrayList<Day>:hin
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
            err = true;
        } catch(ClassNotFoundException c){
            c.printStackTrace();
            Log.d(log, "rikki 2");
            err = true;
        }
        //Yrittää asettaa juuri tiedostosta haetun arraylistin päivälistaksi, jos ei, luo uuden
        //ja dummy päivät
        if(!err) {
            listDays = listHolder;
            Log.d(log, "Lista asetettu");
        } else {
            listDays = new ArrayList<>();
            listDays.add(new Day("2018-09-28", 2700, 73));
            listDays.add(new Day("2018-09-28", 2600, 73));
            listDays.add(new Day("2018-09-29", 3100, 73));
            listDays.add(new Day("2018-09-30", 2300, 73));
            listDays.add(new Day("2018-10-01", 2400, 74));
            listDays.add(new Day("2018-10-02", 3300, 74));
            listDays.add(new Day("2018-10-03", 2500, 74));
            listDays.add(new Day("2018-10-04", 2700, 75));
            listDays.add(new Day("2018-10-05", 2600, 75));
            listDays.add(new Day("2018-10-06", 2900, 75));
            listDays.add(new Day("2018-10-07", 2600, 75));

/*
        listDays = new ArrayList<>();
        listDays.add(new Day("2018-09-28", 1200, 75));
        listDays.add(new Day("2018-09-28", 1100, 75));
        listDays.add(new Day("2018-09-29", 1200, 75));
        listDays.add(new Day("2018-09-30", 1300, 75));
        listDays.add(new Day("2018-10-01", 1400, 73));
        listDays.add(new Day("2018-10-02", 1300, 74));
        listDays.add(new Day("2018-10-03", 1300, 74));
        listDays.add(new Day("2018-10-04", 1200, 73));
        listDays.add(new Day("2018-10-05", 1200, 73));
        listDays.add(new Day("2018-10-06", 1400, 73));
        listDays.add(new Day("2018-10-06", 1100, 73));
*/

        }
        //DayContainer.getInstance().listDays.add(new Day("jee", 32, 43));
        //DayContainer.getInstance().listDays.add(new Day("juu", 47, 98));


    }

    //Find daycontainer method

    /**
     * Metodi on singletonin kutsumismetodi
     * @return palauttaa viittauksen tähän singletoniin
     */
    static DayContainer getInstance() {
        return dayContainer;
    }

    /**
     * Metodi luokan ArrayListin saamiseksi
     * @return Palauttaa ArrayListin luokan sisältä
     */
    public ArrayList<Day> getDaysList() {
        return listDays;
    }

    /**
     * Metodi listasta tietyn päivän etsimiseksi ja palauttamiseksi
     * @param day String joka sisältää päivämäärätiedon jota verrataan arraylistiin
     * @return palauttaa joko Day olion jos haettu päivämäärä löytyi jos ei, palauttaa null
     */
    public Day getDay(String day) {
        for(int k = 0; this.listDays.size()>k; k++) {
            Day vertaus = this.listDays.get(k);
                if(day.equals(vertaus.getPaiva())) {
                    return vertaus;
                }
            }
        return null;

    }

    /**
     * Metodi laskee kaikki kalorit listasta ja jakaa niiden määrän päiväolioiden määrällä saadakseen
     * keskikalorit/päivä
     * @return String joka sisältää keskimääräiset kalorit per päivä
     */
    public String getAvarangeKcal() {
        double kcal=0;
        for (Day currentday : listDays) {
            kcal += currentday.getKalorit();
        }
        return "Olet syönyt keksimäärin: " + Double.toString(Math.round(kcal/listDays.size()*100)/100) + " kcal/pv";
    }
    /**
     * Metodi painonmuutoksen laskemiseen, vertaa ensimmäistä apin muistissa olevaa painoa nykyiseen
     * @return String joka sisältää paininmuutoksen ja päivien määrän joina appia on käytetty
     */
    public String getPainonMuutos() {
        int paino=listDays.get(0).getPaino();
        int painoNyt=listDays.get(listDays.size()-1).getPaino();
        int paivat=listDays.size();

        if (paino>painoNyt) {
            return "Olet laihtunut " + (Math.abs(painoNyt-paino)) + "kg \n" + paivat +":n päivän aikana";
        }

        if (paino==painoNyt) {
            return "Painosi on pysynyt ennallaan";
        }

        return "Olet Lihonnut " + (painoNyt-paino) + "kg " + paivat +" päivässä";
    }
    /**
     * Metodi kalorien keskikulutuksen laskemiseksi painonmuutoksen ja syötyjen kalorien mukaan
     * vakio 9000kcal per kilo vakion mukaan
     * @return String joka sisältää arvioidun keskikulutuksen
     */
    public String getKeskiKulutus() {
        double kcal=0;
        for (Day currentday : listDays) {
            kcal += currentday.getKalorit();
        }

        int paino=listDays.get(0).getPaino();
        int painoNyt=listDays.get(listDays.size()-1).getPaino();
        double painonMuutos=(painoNyt-paino)*1.00;

        double keskiSyonti=kcal/((listDays.size()*1.00));
        double keskiLaihtuminen=painonMuutos/(listDays.size());

        //String sukupuoli=MainActivity.sex;
        double arvioKulutuksesta;

        //arvioKulutuksesta=keskiLaihtuminen-(Math.round(9000 * 100) / 100);
        //arvioKulutuksesta=keskiLaihtuminen+(Math.round(9000 * 100) / 100);
        //if (sukupuoli.equals("Male")){
        if (keskiLaihtuminen<=0) {
            arvioKulutuksesta=Math.round(keskiSyonti+((-1)*keskiLaihtuminen* 9000) * 100) / 100;
            //arvioKulutuksesta = -((Math.round(keskiLaihtuminen * 9000 * 100) / 100)-keskiSyonti) ;
        } else {
               arvioKulutuksesta=Math.round(keskiSyonti-keskiLaihtuminen* 9000 * 100) / 100;
            //return "Olet ylittänyt päiväkulutukseksi " + Double.toString(arvioKulutuksesta) + " kcal/pv";
            //arvioKulutuksesta = -((Math.round(keskiLaihtuminen * 9000 * 100) / 100)-keskiSyonti) ;

        }
        //}


        return "Arvioitu päiväkulutukseksi on " + Double.toString(arvioKulutuksesta) + " kcal/pv";
    }

}





