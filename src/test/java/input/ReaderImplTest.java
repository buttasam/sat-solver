package input;

import entity.Formula;
import org.junit.Test;

/**
 * @author Samuel Butta
 */
public class ReaderImplTest {

    @Test
    public void readInstance() throws Exception {

        ReaderImpl reader = new ReaderImpl();
        Formula formula = reader.readInstance("/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_20_30_100.txt");

        System.out.println(formula);
    }

}