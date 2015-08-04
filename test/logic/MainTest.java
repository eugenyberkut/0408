package logic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yevhen on 04.08.2015.
 */
public class MainTest {

    @Test
    public void testSumZP() throws Exception {
        System.out.println("Test sumZP");
        Person[] persons = {
                new Person("", 100, ""),
                new Person("", 200, ""),
                new Person("", 300, "")
        };
        Main main = new Main();
        int expectedResult = 600;
        int result = main.sumZP(persons);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testMaxZP() throws Exception {
        System.out.println("Test maxZP");
        Person[] persons = {
                new Person("A", 100, "1"),
                new Person("B", 300, "2"),
                new Person("C", 200, "34")
        };
        Main main = new Main();
        Person expectedResult = new Person("B", 300, "2");
        Person result = main.maxZP(persons);
        assertEquals(expectedResult, result);
    }
}