package com.mylinkedlist.app;

/**
 * Hello world!
 *
 */
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

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
