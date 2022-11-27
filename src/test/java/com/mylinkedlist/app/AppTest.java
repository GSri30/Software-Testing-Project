package com.mylinkedlist.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void testAddEnd(){
        App linked_list = new App();
        linked_list.add(10);
        assertEquals(linked_list.count, 1);
    }

    @Test
    public void testAddAtId(){
        App linked_list = new App();
        linked_list.add()
    }
}
