package io.zipcoder;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NestedItemCollectionTest {

    Integer[][] integerArray = {{1,2,5,3,4,5}, {4,3,2,1}};
    NestedItemCollection collection;

    @Before
    public void setup(){
        collection = new NestedItemCollection(integerArray);
    }

    @Test
    public void intializeNestedItemsArraySizeTest(){
        int expected = 2;
        int actual = collection.length();
        assertEquals("The value of the initialized array should be 2",expected, actual);
    }

    @Test
    public void iniializedNestedItemsArrayElementTest(){
        NestedItem itemExpected = new NestedItem(integerArray[0]);
        NestedItem itemActual = collection.getAtIndex(0);
        Integer expected = itemExpected.getPrimeNumberCount();
        Integer actual = itemActual.getPrimeNumberCount();
        assertEquals(expected, actual);
    }

    @Test
    public void sortByNumberofPrimesTEST(){
        NestedItem expectedOrder = new NestedItem(new Integer[] {4,3,2,1});
        NestedItem actualOrder = collection.getAtIndex(0);
        assertEquals("We expect to get the correct order of the array",expectedOrder.toString(),actualOrder.toString());
    }

    @Test
    public void checkforOddTEST(){
        int expected = 0;
        int actual = collection.checkforOdd();
    }
}
