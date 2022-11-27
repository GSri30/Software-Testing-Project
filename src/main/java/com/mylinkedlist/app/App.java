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

    int get(int index) //get the data from the given index node
    {
        Node target=head;
        for(int i=0;i<index;i++)
        {
            target=target.next;
        }
        return target.data;
    }

    /*
     * Setter
     */

    void set(int index,int d)
    {
        Node current=head;
        for(int i=0;i<index;i++)
        {
            current=current.next;
        }
        current.data=d;
    }

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

    String add(int index,int d)// add at given index
    {
        int count_=size();
        if(index>0 && (index<count_ || index==count_))
        {
            if(index<count_)
            {
                Node before=head;
                Node n=new Node(d);
                for(int i=0;i<index-1;i++)
                {
                    before=before.next;
                }
                n.next=before.next;
                before.next=n;
                count++;
                return "added successfully";
            }
            else if(index==count_)
            {
                Node n=new Node(d);
                last.next=n;
                last=n;
                count++;
                return "added successfully";
            }
        }
        else if(index==0)
        {
            Node n=new Node(d);
            n.next=head;
            head=n;
            count++;
            return "added successfully";
        }

        return "wrong Index";
    }

    void addFirst(int d)
    {
        add(0,d);
    }

    void addLast(int d)
    {
        add(d);
    }

    /*
     * Remove
     */

    String remove(int index)
    {
        int count_=size();

        if(count_>0 && index>=0 && (index<count_-1 || index>=count_ ))
        {
            if(index==0)
            {
                head=head.next;
                count--;
            }
            if(index<count-1 && index>0)
            {
                Node before=head;
                for(int i=0;i<index-1;i++)
                {
                    before=before.next;
                }
                Node current=before.next;
                before.next=current.next;
                count--;
            }
            else
                return "index is not valid";
        }
        else if(count_==0)
            return "list is empty";
        else if(index<0)
            return "index is not valid";
        else if(index==count_-1)
        {
            Node before=head;
            for(int i=0;i<index-1;i++)
            {
                before=before.next;
            }
            before.next=null;
            last=before;
            count--;
        }

        return "removed";
    }

    void removeNodeGivenAsReference(Node n)
    {
        if(n.next!=null)
        {
            n.data=n.next.data;
            n.next=n.next.next;
            count--;
        }
    }

    /*
     * Swap
     */

    void swap(int d1,Integer d2)
    {
        System.out.println("inside swap"+count);
        Node current=head;
        Node indexd1=null;
        Node indexd2=null;
        for(int i=0;i<count;i++)
        {
            if(current.data==d1 && indexd1==null )
            {
                indexd1=current;
                current=current.next;
            }
            else if(current.data==d2 && indexd2==null)
            {
                indexd2=current;
                current=current.next;
            }
            else
            {
                current=current.next;
            }
        }
        if(indexd1.equals(null) || indexd2.equals(null))
        {
            System.out.println("elements not found");
        }
        else
        {
            indexd1.data=d2;
            indexd2.data=d1;
        }
    }

    public void swapNodes(int x, int y)
    {
        // Nothing to do if x and y are same
        if (x == y) return;

        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x)
        {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y)
        {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;

        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head
            head = currY;

        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    void reverse() {
        last=head;
        Node before = null;
        Node current = head;
        Node after = null;
        while (current != null)
        {
            after = current.next;
            current.next = before;
            before = current;
            current = after;
        }
        head = before;
    }

    void reverseR()
    {
        head=reverseRec(head,null,null);
    }

    Node reverseRec(Node current,Node before,Node after)
    {
        if(current==head)
        {
            last=current;
        }
        if(current.next==null)
        {
            Node x=current;
            current.next=before;
            return x;
        }
        after=current.next;
        current.next=before;
        before=current;
        current=after;
        return reverseRec(current,before,after);
    }

    void reverseByK(int k)
    {
        head=reverseByK(head,null,null,k);
    }
    Node reverseByK(Node current,Node before,Node after,int k)
    {
        Node tempHead=current;
        int kmodify=0;

        while(kmodify<k && current!=null)
        {
            after = current.next;
            current.next = before;
            before = current;
            current = after;
            kmodify++;
        }

        if(current!=null)
            tempHead.next=reverseByK(current,null,null,k);
        else
            last=tempHead;
        return before;

    }

    void reverseAlternateKNodes(int k)
    {
        head=reverseAlternateKNodes(head,null,null,k);
    }
    Node reverseAlternateKNodes(Node current,Node before,Node after,int k)
    {
        Node tempHead=current;
        int kmodify=0;

        while(kmodify<k && current!=null)
        {
            after = current.next;
            current.next = before;
            before = current;
            current = after;
            kmodify++;
        }
        Node lastNode=tempHead;
        int count=0;
        if(current!=null)
            tempHead.next=current;
        while(count<k)
        {
            if(current==null)
                return before;
            else
            {
                lastNode=current;
                current=current.next;
                count++;
            }
        }
        if(current!=null)
            lastNode.next=reverseAlternateKNodes(current,null,null,k);
        else
            last=tempHead;
        return before;

    }


    /*
	Traverse linked list using two pointers. Move one pointer by one and other pointer by two.
	When the fast pointer reaches end slow pointer will reach middle of the linked list.
    */
    String printMiddleElement()
    {
        Node fastPointer=head;
        Node slowPointer=head;
        while(fastPointer.next!=null && fastPointer.next.next!=null)
        {
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
        }
        // System.out.println("middle element is:"+slowPointer.data+"\n");
        String s ="middle element is:"+slowPointer.data;
        return s;
    }

    Node getMiddleElement(Node head)
    {
        Node fastPointer=head;
        Node slowPointer=head;
        while(fastPointer.next!=null && fastPointer.next.next!=null)
        {
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
        }
        return slowPointer;
    }

    void printNthNodeFromLast(int n)
    {
        Node reference=head;
        Node main=head;
        for(int i=1;i<n && reference.next!=null;i++)
            reference=reference.next;
        if(reference==null)
        {
            System.out.println("size exceeds");
            return;
        }
        while(reference.next!=null)
        {
            reference=reference.next;
            main=main.next;
        }
        System.out.println(n+"th node from the last is:"+main.data);
    }


    boolean isPalindrom()
    {
        Node middle=head;
        Node fastPointer=head;
        Node slowPointer=head;
        //find out middle node
        while(fastPointer.next!=null && fastPointer.next.next!=null)
        {
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
        }
        middle=slowPointer.next;
        Node link=reverseRec(middle,null,null);

        slowPointer.next=link;

        printList();
        Node i=head;
        Node j=slowPointer.next;
        while(j!=null)
        {
            if(i.data==j.data)
            {
                i=i.next;
                j=j.next;
            }
            else
                return false;
        }
        Node link1=reverseRec(slowPointer.next,null,null);
        slowPointer.next=link1;
        return true;
    }



    String printList()
    {
        Node current=head;
        String s = "";
        while(current!=null)
        {
            // System.out.print(current.data+"  ");
            s=s + current.data + " ";
            current=current.next;
        }
        return s;
    }

     /*
    Floyd’s Cycle-Finding Algorithm:
    This is the fastest method. Traverse linked list using two pointers.
    Move one pointer by one and other pointer by two.
    If these pointers meet at some node then there is a loop.
    If pointers do not meet then linked list doesn’t have loop.
    */
    boolean findLoop()
    {
        if(head == null) return false;
        Node fastPointer=head;
        Node slowPointer=head;
        while(fastPointer.next!=null && fastPointer.next.next!=null)
        {
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
            if(fastPointer==slowPointer)
                return true;
        }
        return false;

    }

    String mergeTwoSorted(App liM1,App liM2)
    {
        Node curr1=liM1.head;
        Node curr2=liM2.head;

        Node tmpHead=null;
        Node modifierNode=null;
        while(true)
        {
            if(curr1!=null && curr2!=null && curr1.data < curr2.data && modifierNode==null)
            {

                this.head=curr1;
                modifierNode=curr1;
                curr1=curr1.next;
            }
            else if(curr1!=null && curr2!=null && curr1.data < curr2.data && modifierNode!=null)
            {
                modifierNode.next=curr1;
                modifierNode=curr1;
                curr1=curr1.next;

            }
            else if(curr1!=null && curr2!=null && curr2.data < curr1.data && modifierNode==null)
            {
                this.head=curr2;
                modifierNode=curr2;
                curr2=curr2.next;

            }
            else if(curr1!=null && curr2!=null && curr2.data < curr1.data && modifierNode!=null)
            {
                modifierNode.next=curr2;
                modifierNode=curr2;
                curr2=curr2.next;

            }
            else if(curr1!=null && curr2!=null)//duplicate nodes remove
            {
                if(modifierNode==null)
                {
                    this.head=curr1;
                    modifierNode=curr1;
                    curr1=curr1.next;
                    curr2=curr2.next;
                }
                else
                {
                    modifierNode.next=curr1;
                    modifierNode=curr1;
                    curr1=curr1.next;
                    curr2=curr2.next;
                }
            }
            else
                break;

        }

        if(curr1==null)
        {
            modifierNode.next=curr2;
        }
        if(curr2==null)
        {
            modifierNode.next=curr1;
        }
        Node curr=this.head;
        StringBuilder sb=new StringBuilder();
        while(curr!=null)
        {
            sb.append(curr.data);
            curr=curr.next;
        }
        return sb.toString();

    }


    void printReverse()
    {
        printReverse(head);
        System.out.println("");
    }

    void printReverse(Node current)
    {
        if(current.next!=null)
            printReverse(current.next);
        System.out.print(current.data+"  "); //tail recursion
    }
}
