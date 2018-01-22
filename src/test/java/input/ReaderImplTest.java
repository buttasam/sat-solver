package input;

import entity.Configuration;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Samuel Butta
 */
public class ReaderImplTest {

    @Test
    public void readInstance() throws Exception {

        ReaderImpl reader = new ReaderImpl();
        Configuration configuration = reader.readInstance("/home/samik/IdeaProjects/sat-solver/src/main/resources/data/sat_20_30_100.txt");

        System.out.println(configuration);
    }

}