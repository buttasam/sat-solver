package entity;

/**
 * @author Samuel Butta
 */
public class Clause {

    private int x1, x2, x3;

    private int[] variables = new int[3];

    public Clause(int x1, int x2, int x3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }
}