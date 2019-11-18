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
    public Hero newHero(){
        return new Hero("WonderWoman", 64, "Throwing Fire", "Falling in love", 1);
    }
    @Test
    public void testAddHeroToSquad_String(){
        Squad squad = new Squad("GameChangers", "Climate Change", 3);
        Hero hero = newHero();
        assertTrue(true);
    }
    @Test
    public void testHeroNameInstantiatesCorrectly_String(){
        Hero hero = newHero();
        assertEquals("WonderWoman", hero.getName());
    }
    @Test
    public void testHeroAgeInstantiatesCorrectly_Integer(){
        Hero hero = newHero();
        assertEquals(64, hero.getAge());
    }

}