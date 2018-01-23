package input;

import entity.Formula;
import entity.Result;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Samuel Butta
 */
public class ReaderImplTest {

    @Test
    public void readResult() throws Exception {
        ReaderImpl reader = new ReaderImpl();

        Result result = reader.readResult("/home/samik/IdeaProjects/sat-solver/src/test/resources/result/sat_3_3_100.txt");
        Assert.assertEquals(126, result.getBestWeight());
    }

    @Test
    public void readInstance() throws Exception {

        ReaderImpl reader = new ReaderImpl();
        Formula formula = reader.readInstance("/home/samik/IdeaProjects/sat-solver/src/test/resources/data/sat_20_30_100.txt");

        System.out.println(formula);
    }

}