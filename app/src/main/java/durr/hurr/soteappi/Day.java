package durr.hurr.soteappi;

/**
 * @author Konsta
 */
public class Day {
    private int paino;
    private int kalorit;
    private String paiva;

    public Day(String paiva, int kalorit, int paino) {
        this.paiva = paiva;
        this.paino = paino;
        this.kalorit = kalorit;
    }

    public void setPainoa(int lisaa) {
        this.paino = lisaa;
    }

    public void setKaloreita(int lisaa) {
        this.kalorit = this.kalorit + lisaa;
    }

    public int getPaino() {
        return this.paino;
    }

    public int getKalorit() {
        return this.kalorit;
    }

    public String getPaiva() {
        return this.paiva;
    }

    @Override
    public String toString() {
        return this.paiva + " - " + this.kalorit + "kcal   " + this.paino + "kg";
    }

}
