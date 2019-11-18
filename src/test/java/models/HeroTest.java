package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testHeroInstantiatesCorrectly_true(){
        Hero hero = new Hero("WonderWoman", 64, "Throwing Fire", "Falling in love", 1);
        assertTrue(hero instanceof Hero);
    }
    @Test
}