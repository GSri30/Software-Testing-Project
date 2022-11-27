package com.mylinkedlist.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void testSizeWithNull(){
        App linked_list = new App();
        int sz = linked_list.size(null);
        assertEquals(sz, 0);
    }

    @Test
    public void testAddEnd(){
        App linked_list = new App();
        linked_list.addLast(10);
        assertEquals(linked_list.count, 1);
    }
}
