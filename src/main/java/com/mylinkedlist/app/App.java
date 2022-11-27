package com.mylinkedlist.app;


class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data=data;
        next=null;
    }
    Node(){}
}

public class App 
{
    Node head=null;
    Node last=null;
    int count=0; //total nodes in the list

    /*
     * Size
     */

    int size()
    {
        int x=size(head);
        return x;
    }
    
    int size(Node n)
    {
        if(n==null)
            return 0;
        else return(1+ size(n.next));
    }

    /*
     * Getter
     */

    // int get(int index) //get the data from the given index node
    // {
    //     Node target=head;
    //     for(int i=0;i<index;i++)
    //     {
    //         target=target.next;
    //     }
    //     return target.data;
    // }

    /*
     * Setter
     */

    // void set(int index,int d)
    // {
    //     Node current=head;
    //     for(int i=0;i<index;i++)
    //     {
    //         current=current.next;
    //     }
    //     current.data=d;
    // }

    /*
     * Add
     */

    void add(int d) //add at the end of the list
    {
        Node n=new Node(d);
        if(head!=null)
        {
            last.next=n;
            last=n;
            count++;
        }
        else
        {
            head=n;
            last=n;
            count++;
        }
    }

    // String add(int index,int d)// add at given index
    // {
    //     int count=size();
    //     if(index>0 && (index<count || index==count))
    //     {
    //         if(index<count)
    //         {
    //             Node before=head;
    //             Node n=new Node(d);
    //             for(int i=0;i<index-1;i++)
    //             {
    //                 before=before.next;
    //             }
    //             n.next=before.next;
    //             before.next=n;
    //             count++;
    //             return "added successfully";
    //         }
    //         else if(index==count)
    //         {
    //             Node n=new Node(d);
    //             last.next=n;
    //             last=n;
    //             count++;
    //             return "added successfully";
    //         }
    //     }
    //     else if(index==0)
    //     {
    //         Node n=new Node(d);
    //         n.next=head;
    //         head=n;
    //         count++;
    //         return "added successfully";
    //     }

    //     return "wrong Index";
    // }

    // void addFirst(int d)
    // {
    //     add(0,d);
    // }

    void addLast(int d)
    {
        add(d);
    }

    /*
     * Remove
     */

    // String remove(int index)
    // {
    //     int count=size();

    //     if(count>0 && index>=0 && (index<count-1 || index>=count ))
    //     {
    //         if(index==0)
    //         {
    //             head=head.next;
    //             count--;
    //         }
    //         if(index<count-1 && index>0)
    //         {
    //             Node before=head;
    //             for(int i=0;i<index-1;i++)
    //             {
    //                 before=before.next;
    //             }
    //             Node current=before.next;
    //             before.next=current.next;
    //             count--;
    //         }
    //         else
    //             return "index is not valid";
    //     }
    //     else if(count==0)
    //         return "list is empty";
    //     else if(index<0)
    //         return "index is not valid";
    //     else if(index==count-1)
    //     {
    //         Node before=head;
    //         for(int i=0;i<index-1;i++)
    //         {
    //             before=before.next;
    //         }
    //         before.next=null;
    //         last=before;
    //         count--;
    //     }

    //     return "removed";
    // }

    // void removeNodeGivenAsReference(Node n)
    // {
    //     if(n.next!=null)
    //     {
    //         n.data=n.next.data;
    //         n.next=n.next.next;
    //     }
    // }

    /*
     * Swap
     */

    // void swap(int d1,Integer d2)
    // {
    //     System.out.println("inside swap"+count);
    //     Node current=head;
    //     Node indexd1=null;
    //     Node indexd2=null;
    //     for(int i=0;i<count;i++)
    //     {
    //         if(current.data==d1 && indexd1==null )
    //         {
    //             indexd1=current;
    //             current=current.next;
    //         }
    //         else if(current.data==d2 && indexd2==null)
    //         {
    //             indexd2=current;
    //             current=current.next;
    //         }
    //         else
    //         {
    //             current=current.next;
    //         }
    //     }
    //     if(indexd1.equals(null) || indexd2.equals(null))
    //     {
    //         System.out.println("elements not found");
    //     }
    //     else
    //     {
    //         indexd1.data=d2;
    //         indexd2.data=d1;
    //     }
    // }

    // void swapWithoutData(int d1,int d2)
    // {
    //     add(0);
    //     Node before1=null;
    //     Node current=head;
    //     Node after1=null;
    //     Node before2=null;
    //     Node after2=null;
    //     Node indexd1=null;
    //     Node indexd2=null;
    //     for(int i=0;i<count-1;i++)
    //     {
    //         if(current.next.data == d1)
    //         {
    //             before1=current;
    //             indexd1=current.next;
    //             after1=indexd1.next;
    //             current=current.next;

    //         }
    //         else if(current.next.data == d2)
    //         {
    //             before2=current;
    //             indexd2=current.next;
    //             after2=indexd2.next;
    //             current=current.next;
    //         }
    //         else
    //         {
    //             current=current.next;
    //         }

    //     }
    //     if(indexd1==last)
    //         last=indexd2;
    //     if(indexd2==last)
    //         last=indexd1;
    //     before1.next=indexd2;
    //     indexd2.next=after1;
    //     before2.next=indexd1;
    //     indexd1.next=after2;
    //     remove(0);
    // }

    // public void swapNodes(int x, int y)
    // {
    //     // Nothing to do if x and y are same
    //     if (x == y) return;

    //     // Search for x (keep track of prevX and CurrX)
    //     Node prevX = null, currX = head;
    //     while (currX != null && currX.data != x)
    //     {
    //         prevX = currX;
    //         currX = currX.next;
    //     }

    //     // Search for y (keep track of prevY and currY)
    //     Node prevY = null, currY = head;
    //     while (currY != null && currY.data != y)
    //     {
    //         prevY = currY;
    //         currY = currY.next;
    //     }

    //     // If either x or y is not present, nothing to do
    //     if (currX == null || currY == null)
    //         return;

    //     // If x is not head of linked list
    //     if (prevX != null)
    //         prevX.next = currY;
    //     else //make y the new head
    //         head = currY;

    //     // If y is not head of linked list
    //     if (prevY != null)
    //         prevY.next = currX;
    //     else // make x the new head
    //         head = currX;

    //     // Swap next pointers
    //     Node temp = currX.next;
    //     currX.next = currY.next;
    //     currY.next = temp;
    // }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
