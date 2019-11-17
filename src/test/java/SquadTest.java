import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testSquadInstantiatesCorrectly_true(){
        Squad squad = new Squad("GameChangers", "Climate Change", 3);
        assertTrue( squad instanceof Squad);
    }
    @Test
    public void testGetName_String(){
        Squad squad = new Squad("GameChangers", "Climate Change", 3);
        assertEquals("GameChangers", squad.getName());
    }
    @Test
    public void testGetCause_String(){
        Squad squad = new Squad("GameChangers", "Climate Change", 3);
        assertEquals("Climate Change", squad.getCause());


}