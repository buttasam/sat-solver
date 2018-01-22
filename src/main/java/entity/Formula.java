package entity;

/**
 * @author Samuel Butta
 */
public class Formula {


    /**
     * Počet klauzulí
     */
    private int clausesCount;


    private Clause[] clauses;


    public Formula(int clausesCount) {
        this.clausesCount = clausesCount;
    }

}
