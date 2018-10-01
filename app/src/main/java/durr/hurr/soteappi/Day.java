package durr.hurr.soteappi;

/**
 * @author Konsta
 */
public class Day {
    private int paino;
    private int kalorit;
    private String paiva;

    public Day(String paiva) {
        this.paiva = paiva;
        this.paino = 0;
        this.kalorit = 0;
    }

    public Day(String paiva, int kalorit) {
        this.paiva = paiva;
        this.paino = 0;
        this.kalorit = kalorit;
    }

    public Day(String paiva, int kalorit, int paino) {
        this.paiva = paiva;
        this.paino = paino;
        this. kalorit = kalorit;
    }

    public void lisaaPainoa(int lisaa) {
        this.paino = lisaa;
    }

    public void lisaaKaloreita(int lisaa) {
        this.kalorit = this.kalorit + lisaa;
    }

    public int getPaino() {
        return this.paino;
    }

    public int getKalorit() {
        return this.kalorit;
    }

    @Override
    public String toString() {
        return this.paiva;
    }

}
