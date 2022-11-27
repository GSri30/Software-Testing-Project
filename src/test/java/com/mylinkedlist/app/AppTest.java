package com.mylinkedlist.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testSize(){
        testSizeWithNull();
        testSizeNonEmpty();
    }

    public void testSizeWithNull(){
        App linked_list = new App();
        int sz = linked_list.size(null);
        assertEquals(sz, 0);
    }

    public void testSizeNonEmpty(){
        App linked_list = new App();
        linked_list.addLast(1);
        linked_list.addLast(2);
        assertEquals(linked_list.size(), 2);
        assertEquals(linked_list.count, 2);

    }

    @Test
    public void testAddEnd(){
        App linked_list = new App();
        linked_list.addLast(10);
        assertEquals(linked_list.count, 1);
    }

    @Test
    public void testGetterSetter(){
        App linked_list =new App();
        linked_list.addLast(5);
        linked_list.addLast(10);
        linked_list.addLast(15);
        assertEquals(linked_list.get(0), 5);
        assertEquals(linked_list.get(1), 10);
        linked_list.set(2, 20);
        assertEquals(linked_list.get(2), 20);
    }

    
    @Test
    public void testAddAtIdx(){
        App linked_list = new App();
        linked_list.add(0);
        assertEquals(linked_list.add(0, 1), "added successfully");
        assertEquals(linked_list.add(1, 2), "added successfully");
        assertEquals(linked_list.add(3, 3), "added successfully");
        assertEquals(linked_list.add(100, 3), "wrong Index");
        assertEquals(linked_list.count, 4);
        assertEquals(linked_list.add(2,100), "added successfully");
        assertEquals(linked_list.add(-1,0), "wrong Index");
    }

    @Test
    public void testAddFirst(){
        App linked_list = new App();
        linked_list.addFirst(0);
        assertEquals(linked_list.count, 1);
    }

    @Test
    public void testRemove(){
        App linked_list1 = new App();
        linked_list1.addFirst(0);
        assertEquals(linked_list1.remove(0), "removed");
        assertEquals(linked_list1.count, 0);

        App linked_list2 = new App();
        assertEquals(linked_list2.remove(0), "list is empty");
        

        App linked_list3 = new App();
        linked_list3.addLast(0);
        linked_list3.addLast(1);
        assertEquals(linked_list3.remove(-1), "index is not valid");
        assertEquals(linked_list3.remove(1), "removed");
        assertEquals(linked_list3.count, 1);

        App linked_list4 = new App();
        linked_list4.addLast(0);
        linked_list4.addLast(1);
        linked_list4.addLast(2);
        linked_list4.addLast(3);
        assertEquals(linked_list4.remove(2), "removed");
        assertEquals(linked_list4.count, 3);
        
        App linked_list5 = new App();
        linked_list5.add(0);
        linked_list5.add(1);
        linked_list5.add(2);
        linked_list5.add(3);
        assertEquals(linked_list5.remove(5), "index is not valid");
        linked_list5.remove(3);
        assertEquals(linked_list5.count, 3);

    }

    @Test
    public void testRemoveAsRef(){
        App linked_list1 = new App();
        linked_list1.add(0);
        linked_list1.add(1);
        linked_list1.add(2);
        Node n = linked_list1.head.next;
        linked_list1.removeNodeGivenAsReference(n);
        assertEquals(linked_list1.count, 2);
    }

    @Test
    public void testSwap(){
        App linked_list1 = new App();
        linked_list1.add(0);
        linked_list1.add(1);
        linked_list1.add(2);
        linked_list1.swap(0, 2);
        assertEquals(linked_list1.get(0), 2);
        
        linked_list1.swap(1,2);
        assertEquals(linked_list1.get(0), 1);
    }

    @Test
    public void testSwapNodes(){
        App linked_list1 = new App();
        linked_list1.addLast(0);
        linked_list1.addLast(1);
        linked_list1.addLast(2);
        linked_list1.swapNodes(0, 0);
        assertEquals(linked_list1.count, 3);
        linked_list1.swapNodes(0, 1);
        assertEquals(linked_list1.get(0),1);
        linked_list1.swapNodes(1, 2);
        assertEquals(linked_list1.get(0), 2);
        linked_list1.swapNodes(3, 0);
        assertEquals(linked_list1.count, 3);

        App linked_list2 = new App();
        linked_list2.swapNodes(0, 1);
        assertEquals(linked_list2.count, 0);
        linked_list2.addLast(0);
        linked_list2.addLast(1);
        linked_list2.addLast(2);
        linked_list2.swapNodes(1,2);
        assertEquals(linked_list2.get(2), 1);
        linked_list2.swapNodes(2,0);
        assertEquals(linked_list2.get(0), 2);
    }

    @Test
    public void testReverse(){
        App linked_list1 = new App();
        linked_list1.add(0);
        linked_list1.add(1);
        linked_list1.add(2);
        linked_list1.reverse();
        assertEquals(linked_list1.get(0), 2);
    }
    @Test
    public void testprintList(){
        App linked_list1 = new App();
        linked_list1.add(0);
        linked_list1.add(1);
        linked_list1.add(2);
        // String s = linked_list1.printList();
        // System.out.println(s);
        assertEquals(linked_list1.printList(), "0 1 2 ");
    }

    @Test
    public void testReverseR(){
        App linked_list1 = new App();
        linked_list1.add(0);
        linked_list1.add(1);
        linked_list1.add(2);
        linked_list1.reverseR();
        assertEquals(linked_list1.get(0), 2);


        App linked_list2 = new App();
        linked_list2.add(0);
        linked_list2.reverseR();
        assertEquals(linked_list2.get(0), 0);
    }

    @Test
    public void testReverseByK(){
        App linked_list1 = new App();
        linked_list1.add(0);
        linked_list1.add(1);
        linked_list1.add(2);
        linked_list1.add(3);
        linked_list1.reverseByK(2);
        assertEquals(linked_list1.get(2), 3);
    }

    @Test
    public void testreverseAlternateKNodes(){
        App linked_list1 = new App();
        linked_list1.add(0);
        linked_list1.add(1);
        linked_list1.add(2);
        linked_list1.add(3);
        linked_list1.add(4);
        linked_list1.add(5);
       
        linked_list1.reverseAlternateKNodes(2);
        assertEquals(linked_list1.get(2), 2);

        linked_list1.reverseAlternateKNodes(6);
        assertEquals(linked_list1.get(0), 4);
    }
    

    @Test
    public void testprintMiddleElement(){
        App linked_list1 = new App();
        linked_list1.add(0);
        linked_list1.add(1);
        linked_list1.add(2);
        assertEquals(linked_list1.printMiddleElement(), "middle element is:1");
    }

    @Test
    public void testgetMiddleElement(){
        App linked_list1 = new App();
        linked_list1.add(0);
        linked_list1.add(1);
        linked_list1.add(2);
        Node mid = linked_list1.getMiddleElement(linked_list1.head);
        assertEquals(mid.data,1);
    }

    @Test
    public void testprintNthNodeFromLast(){
        App linked_list1 = new App();
        linked_list1.add(0);
        linked_list1.add(1);
        linked_list1.add(2);
        linked_list1.add(3);
        linked_list1.printNthNodeFromLast(2);
        assertEquals(linked_list1.get(2), 2);
        linked_list1.printNthNodeFromLast(5);


        App linked_list2 = new App();
        linked_list2.printNthNodeFromLast(0);
    }

    @Test
    public void testisPalindrome(){
        App linked_list1 = new App();
        linked_list1.add(0);
        linked_list1.add(1);
        linked_list1.add(2);
        linked_list1.add(1);
        linked_list1.add(0);

        assertEquals(linked_list1.isPalindrom(), true);
        
        App linked_list2 = new App();
        linked_list2.add(0);
        linked_list2.add(1);
        linked_list2.add(2);

        assertEquals(linked_list2.isPalindrom(), false);
    
    }

    @Test
    public void testfindLoop(){
        App linked_list = new App();
        assertEquals(linked_list.findLoop(), false);
        linked_list.add(10);
        assertEquals(linked_list.findLoop(), false);
        linked_list.add(20);
        linked_list.last.next = linked_list.head;
        assertEquals(linked_list.findLoop(), true);
        
        App linked_list1 = new App();
        linked_list1.add(10);
        linked_list1.add(20);
        linked_list1.add(30);
        linked_list1.add(40);
        linked_list1.last.next = linked_list1.head;
        assertEquals(linked_list1.findLoop(), true);

    }

    @Test
    public void testmergetwosorted(){
        App linked_list1 = new App();
        linked_list1.add(0);
        linked_list1.add(2);
        linked_list1.add(4);

        App linked_list2 = new App();
        linked_list2.add(1);
        linked_list2.add(3);
        linked_list2.add(5);

        assertEquals(linked_list1.mergeTwoSorted(linked_list1, linked_list2), "012345");
    
        App linked_list3 = new App();
        linked_list3.add(1);
        linked_list3.add(5);

        App linked_list4 = new App();
        linked_list4.add(1);
        linked_list4.add(3);
        
        assertEquals(linked_list3.mergeTwoSorted(linked_list3, linked_list4), "135");

        App linked_list5 = new App();
        linked_list5.add(1);
        linked_list5.add(2);

        App linked_list6 = new App();
        linked_list6.add(1);
        linked_list6.add(2);

        assertEquals(linked_list5.mergeTwoSorted(linked_list5, linked_list6), "12");

    
    }

   

}
