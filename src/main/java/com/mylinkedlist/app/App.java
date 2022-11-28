package com.mylinkedlist.app;
import java.util.*;

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
            else if(index<count_-1 && index>0)
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

    void swap(int d1, int d2)
    {
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
        if(indexd1 == null || indexd2 == null)
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
    }

    void printReverse(Node current)
    {
        if(current.next!=null)
            printReverse(current.next);
        System.out.print(current.data+" "); //tail recursion
    }

    void removeDuplicatesInSortedList()
    {
        Node pre=null;
        Node current=head;
        if(head==null)
            return;
        while(current.next!=null)
        {
            pre=current;
            current=current.next;
            if(pre.data==current.data)
            {
                pre.next=current.next;
                current=pre;
            }
        }
    }

    void removeDuplicatesInUnsortedList()
    {
        HashMap<Integer,Boolean> hm=new HashMap<Integer,Boolean>();
        Node current=head;
        Node pre=null;
        while(current!=null)
        {
            if(hm.containsKey(current.data))
            {
                pre.next=current.next;
                current=pre.next;
            }
            else
            {
                hm.put(current.data,true);
                pre=current;
                current=current.next;
            }
        }
    }

    String swapPairWise()
    {
        swapPairWise(head,head.next,null);
        Node curr=this.head;
        StringBuilder sb=new StringBuilder();
        while(curr!=null)
        {
            sb.append(curr.data);
            curr=curr.next;
        }
        return sb.toString();
    }

    void swapPairWise(Node pre,Node current,Node prePre)
    {
        if(pre==null || current==null || pre==head)
        {
            if(pre==null || current==null)
            {
                return;
            }
            if(pre==head)
            {
                head=head.next;
            }
        }
        pre.next=current.next;
        current.next=pre;
        if(prePre!=null)
        {
            prePre.next=current;
        }
        prePre=pre;
        pre=pre.next;
        //here for even length pre will be null
        //so current=pre.next only if pre!=null
        //otherwise it will give nullpointerException!
        if(pre!=null)
        {
            current=pre.next;
        }
        swapPairWise(pre,current,prePre);
    }

    void intersectionOfLists(App list1,App list2)
    {
        Node n1=list1.head;
        Node n2=list2.head;
        head=intersection(n1,n2);
    }

    Node intersection(Node n1,Node n2)
    {
        if(n1==null || n2==null)
            return null;
        if(n1.data<n2.data)
            return intersection(n1.next,n2);
        if(n2.data<n1.data)
            return intersection(n1,n2.next);
        Node n=new Node(n1.data);
        n.next=intersection(n1.next,n2.next);
        return n;
    
    }

    void removeAlternateNodes()
    {
        int i=0;
        Node pre=null;
        Node current=head;
        while(current!=null)
        {
            if(i%2==0)
            {
                pre=current;
                current=current.next;
                i++;
            }
            else
            {
                pre.next=current.next;
                current=current.next;
                i++;
            }
        }
    }

    void removeAlternateNodesRecurcive()
    {
        removeAlternateNodesRecurcive(head);
    }
    
    void removeAlternateNodesRecurcive(Node current)
    {
        if(current==null || current.next==null )
            return;
        if(current.next.next!=null)
            current.next=current.next.next;
        else
            current.next=null;
        removeAlternateNodesRecurcive(current.next);
    }

    void alternatingSplit(App l)
    {
        if(head==null)
            return;
        Node head1=head;
        Node last1=head1;
        Node head2=null;
        Node last2=null;
        Node current=head.next;
        int i=0;
        while(current!=null)
        {
            if(i%2==0)
            {
                if(head2==null)
                {
                    head2=current;
                    last2=head2;
                    i++;
                    current=current.next;
                }
                else
                {
                    last2.next=current;
                    last2=last2.next;
                    i++;
                    current=current.next;
                }
            }
            else
            {
                last1.next=current;
                last1=last1.next;
                i++;
                current=current.next;
            }
        }
        if(i%2==0)
            last2.next=null;
        else
            last1.next=null;
        //l1.head=head1;
        l.head=head2;
    }

    String isIdentical(App l1, App l2)
    {
        Node n1=l1.head;
        Node n2=l2.head;
        String result=isIdentical(n1,n2);
        return result;
    }

    String isIdentical(Node n1,Node n2)
    {
        if(n1==null && n2==null)
        {
            return "Identical";
        }
        else if(n1!=null && n2!=null && n1.data==n2.data)
        {
            return isIdentical(n1.next,n2.next);
        }
        else
        {
            return "Not Identical";
        }
    }

    //Merge Sort link-list
    //we use the same divide and conquer approach
    // to partition we need to write one function as well
    //1. partition
    //2. recursively call both half
    //3. until both have one element => call then mergeList

    void mergeSort()
    {
        this.head=doMergeSort(head);
    }

    Node doMergeSort(Node head)
    {
        //single node, or no node=> return that
        if(head==null || head.next==null)
            return head;

        Node middle=getMiddleElement(head);

        //divide the list into two parts
        Node front=head;
        Node back=middle.next;
        middle.next=null;

        //recursively call to partition list into two lists
        front=doMergeSort(front);
        back=doMergeSort(back);

        //front and back will contain the list into chunnks at each page
        //merge the list in bottom up approach
        //and set the head of the list and return
        head=mergeLists(front, back);
        return head;
    }

    //1st time call to merge=> only two nodes
    //then, it will always be two sorted list
    //so merge of two sorted list
    Node mergeLists(Node curr1,Node curr2)
    {
        Node head=null;
        Node modifierNode=null;

        //if any one list is empty, simply return the other
        if(curr1==null)
        {
            return curr2;
        }
        else if(curr2==null)
        {
            return curr1;
        }

        //modifier node is the one with correct order
        // curr1 and curr2 are compared and set to next of modifier

        while(curr1!=null && curr2!=null)
        {
            //<= becoz to preserve the order of nodes in original list
            if(curr1.data <= curr2.data)
            {
                if(modifierNode==null)
                {
                    head=curr1;
                    modifierNode=curr1;
                    curr1=curr1.next;
                }
                else
                {
                    modifierNode.next=curr1;
                    modifierNode=curr1;
                    curr1=curr1.next;

                }
            }
            else //(curr2.data < curr1.data)
            {
                if(modifierNode==null)
                {
                    head=curr2;
                    modifierNode=curr2;
                    curr2=curr2.next;
                }
                else
                {
                    modifierNode.next=curr2;
                    modifierNode=curr2;
                    curr2=curr2.next;

                }
            }
        }


        //once a list is empty=> just join the other list at the end
        if(curr1==null)
        {
            modifierNode.next=curr2;
        }
        if(curr2==null)
        {
            modifierNode.next=curr1;
        }

        return head;


    }//end of mergeLists

    void removeifrightSideNodeIsGreater()
    {
        if(head == null) return;
        removeifrightSideNodeIsGreater(null,head,head.next);
    }

    void removeifrightSideNodeIsGreater(Node pre,Node current,Node after)
    {
        if(current==null || current.next ==null)
        {
            return;
        }
        else if(current.data<after.data)
        {
            if(current==head)
            {
                head=after;
                removeifrightSideNodeIsGreater(null,head,head.next);
            }
            else
            {
                pre.next=after;
                removeifrightSideNodeIsGreater(pre,after,after.next);
            }
        }
        else
        {
            removeifrightSideNodeIsGreater(current,after,after.next);
        }
    }

    void removeNodeifAnyRHSisBigger()
    {
        //first reverse the list
        //and assign max node
        //all nodes right side to it smaller than max must be deleted
        //which is same as given question in reverse order
        //then if max is lesser change max
        //in the end again reverse the list.
        this.reverseR();
        Node max=head;
        Node current=head.next;
        while(current!=null)
        {
            if(max.data<=current.data)
            {
                max=max.next;
                current=current.next;
            }
            else
            {
                max.next=current.next;
                current=current.next;
            }
        }
        this.reverseR();
    }

    void evenDataFirst()
    {
        //shift all odd elements to the end of the list
        //it will not even change the order of odd and even elements
        Node pre=null;
        Node current=head;
        //Node tempLast=last;
        if(head==null || head.next==null)
        {
            return;
        }
        int count=size(head);
        while(count>0)
        {
            if(current.data%2==0)
            {
                pre=current;
                current=current.next;
                count--;
            }
            else
            {
                if(current==head)
                {
                    head=current.next;
                }
                else
                {
                    pre.next=current.next;
                }
                last.next=current;
                last=current;
                current=current.next;
                last.next=null;
                count--;
            }
        }
    }

    // String addtwoListNumber(App list1, App list2, int carry)
    // {
    //     return addtwoListNumber(list1.head,list2.head,carry);
    // }

    // String addtwoListNumber(Node n1, Node n2, int carry)
    // {
    //     if(n1==null && n2==null && carry>0)
    //     {
    //         Node n=new Node(1);
    //         if(head==null)
    //         {
    //             head=n;
    //             last=n;
    //         }
    //         last.next=n;
    //         last=last.next;
    //         return "carry added";
    //     }
    //     else if(n1==null && n2==null)
    //     {
    //         return "addition is completed";
    //     }
    //     else
    //     {
    //         int value=0;
    //         if(n1!=null && n2!=null)
    //         {
    //             value=n1.data+n2.data+carry;
    //         }
    //         else if(n1==null)
    //         {
    //             value=n2.data+carry;
    //         }
    //         else if(n2==null)
    //         {
    //             value=n1.data+carry;
    //         }
    //         carry=value/10;
    //         int m=value%10;
    //         Node n = new Node(m);
    //         if(this.head==null)
    //         {
    //             head=n;
    //             last=n;
    //         }
    //         else
    //         {
    //             last.next=n;
    //             last=last.next;
    //         }
    //         System.out.println(n1.data+" "+n2.data+" carry:"+carry);
    //         if(n1!=null && n2!=null)
    //         {
    //             return addtwoListNumber(n1.next,n2.next,carry);
    //         }
    //         else if(n1==null)
    //         {
    //             return addtwoListNumber(null,n2.next,carry);
    //         }
    //         else if(n2==null)
    //         {
    //             return addtwoListNumber(n1.next,null,carry);
    //         }
    //         return null;
    //     }
    // }
}
