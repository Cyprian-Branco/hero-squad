import models.Squad;
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
    public void testGetCause_String() {
        Squad squad = new Squad("GameChangers", "Climate Change", 3);
        assertEquals("Climate Change", squad.getCause());

    }
    @Test
    public void testGetMax_size_Integer() {
        Squad squad = new Squad("GameChangers", "Climate Change", 3);
        assertEquals(3, squad.getMax_size());
    }
    @Test
    public void testSquadReturnedCorrectly_true(){
        Squad squad = new Squad("GameChangers", "Climate Change", 3);
        Squad otherSquad = new Squad("Avengers", "Save the universe", 3);
        assertTrue(Squad.getInstances().contains(squad));
        assertTrue(Squad.getInstances().contains(otherSquad));
    }
    @Test
    public void testSquadFindById_String(){
        Squad squad = new Squad("GameChangers", "Climate Change", 3);
        Squad otherSquad = new Squad("Avengers", "Save the universe", 3);
        assertEquals(2, Squad.findById(otherSquad.getId()));
    }
}