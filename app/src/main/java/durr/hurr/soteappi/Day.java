package durr.hurr.soteappi;

import java.io.Serializable;

/**
 * Luokka päivämäärän ja syötyjen kalorien ja painon tallentamista varten
 * @author Konsta
 */
public class Day implements Serializable {
    private int paino;
    private int kalorit;
    private String paiva;

    /**
     * Konstruktori päiväoliolle
     * @param paiva String joka sisältää päivämäärän
     * @param kalorit int Kalorien määrälle jotka on syöty
     * @param paino int käyttäjän painolle
     */
    public Day(String paiva, int kalorit, int paino) {
        this.paiva = paiva;
        this.paino = paino;
        this.kalorit = kalorit;
    }

    /**
     * Metodi painon asettamiseen
     * @param lisaa uusi paino int
     */
    public void setPainoa(int lisaa) {
        this.paino = lisaa;
    }

    /**
     * Metodi joka lisää olion kalori muuttujaan annetut kalorit
     * @param lisaa int lisättävien kalorien määrä
     */
    public void setKaloreita(int lisaa) {
        this.kalorit = this.kalorit + lisaa;
    }

    /**
     * Metodi päivän painon palauttamiseksi
     * @return int arvon joka sisältää päivän painon
     */
    public int getPaino() {
        return this.paino;
    }

    /**
     * Metodi päivän kaloreiden palauttamiseksi
     * @return int arvo joka sisältää päivän kalorit
     */
    public int getKalorit() {
        return this.kalorit;
    }

    /**
     * Metodi päivän päivämäärän palauttamiseksi
     * @return String joka sisältää päivämäärän tälle päivällä stringissä
     */
    public String getPaiva() {
        return this.paiva;
    }

    /**
     * Muutettu toString joka palauttaa päivän kalorit ja painon Stringinä valmiiksi muotoiltuna
     * @return String joka sisltää tiedot oliosta
     */
    @Override
    public String toString() {
        return this.paiva + " - " + this.kalorit + "kcal   " + this.paino + "kg";
    }

}
