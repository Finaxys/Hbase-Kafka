package fr.finaxys;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ylegars on 09/12/2015.
 */
public class MessageProducerTest {

    private MessageProducer m;

    @Before
    public void setUp() throws Exception {
         m = new MessageProducer("test");
    }

    @After
    public void tearDown() throws Exception {
        m.close();
    }

    @Test
    public void sendTest() {
        m.send();
    }
}