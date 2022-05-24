package com.example.listviewwdatastructureimplementation;

import org.w3c.dom.Node;

public class DoublyLL
{
    Node head, tail, next, prev;
    private int count;

    public int getTailData()
    {
        return tail.getData();
    }

    public DoublyLL()
    {
        Node headNode = null;
        Node tailNode = null;
    }//public default constructor for doubly linked list

    /*
    public int sizeofList(DoublyLL newLL)
    {
        int size = 0;
        int newData = this.data;
        Node newDLLNode = new Node(newData);
        Node headNode = head;
        while (headNode.next != null)
        {
            size++;
            newDLLNode = newDLLNode.next;
        }//end of while
        return size;
    }//end of sizeofList method
    */

    //INSERTIONS METHODS
    public void push(int newData)
    {
        //pushing is the insertion method that inserts a new head node

        Node newDLLNode = new Node(newData); //first create the new temp node

        newDLLNode.setPrev(null); //previous pointer is null; that's what makes it the head
        newDLLNode.setNext(head); //next pointer is linked as head

        if (head != null)
        {
            head.prev = newDLLNode; //links the previous head node's prev to the new head node
        }//end of if conditional

        head = newDLLNode; //finally assign the whole new node as the head node
    }//end of push method (IT WORKSSSSS!!!)

    public void pushAtEnd(int newData)
    {
        Node newDLLNode = new Node(newData); //first create the new temp node

        Node tail = head;

        newDLLNode.next = null;

        if (head == null) //if list is empty then the new node is the head
        {
            newDLLNode.prev = null;
            head = newDLLNode;
            return;
        }//end of if conditional

        while (tail.next != null)
        {
            tail = tail.next;
        }//end of while loop

        tail.next = newDLLNode;

        newDLLNode.prev = tail;
        /*
        //pushing is the insertion method that inserts a new head node
        Node newDLLNode = new Node(newData); //first create the new temp node

        newDLLNode.setPrev(tail); //previous pointer is linked as tail
        newDLLNode.setNext(null); //next pointer is null; because that is what makes a tail

        if (tail != null)
            tail.next = newDLLNode; //links the previous tail node's next to the new tail node

        tail = newDLLNode; //finally assign the whole new node as the tail node*/
    }//end of pushAtEnd method (THIS WORKSSS TOOO!!)

    void pop(Node head_ref, Node del)
    {

        // Base case
        if (head == null || del == null) {
            return;
        }

        // If node to be deleted is head node
        if (head == del) {
            head = del.next;
        }

        // Change next only if node to be deleted
        // is NOT the last node
        if (del.next != null) {
            del.next.prev = del.prev;
        }

        // Change prev only if node to be deleted
        // is NOT the first node
        if (del.prev != null) {
            del.prev.next = del.next;
        }

        // Finally, free the memory occupied by del
        return;
    }

/*
Insertion
A node can be added in four ways
1) At the front of the DLL
2) After a given node.
3) At the end of the DLL
4) Before a given node.
Remove
1) Pop - remove from front
Peak
1) Pop then push
*/

    //OTHER BRAIN METHODS

    public int findSize()
    {
        Node current = head; //start off with the head of the list
        int size = 0; //create a counter int variable
        while (current != null)
        {
            size++;
            current = current.next; //moves on to the next node
        }//end of while loop
        return size;
    }//end of findSize method

    public void showList()
    {
        if(head == null) {
            System.out.println("List is empty");
        }//list null validation
        Node current = head; //start off with the head of the list

        while (current != null) //run below if the node is not the tail; it's not null
        {
            System.out.print(current.data + " ");
            current = current.next; //moves on to the next node

        }//end of while loop
    }//end of showList method

    public Integer[] toArray()
    {
        Integer[] QArray = new Integer[count];



        int position  = getTailData();
        //System.out.println(head.getsData());
        //System.out.println(tail.getsLink().getsData());
        for(int i = 0; i < count; i++)
        {
//            System.out.println(position.getsData());
//            System.out.println("-");
            QArray[i] = position;
            position = position.next();
        }

    //NODE CLASS
        class Node
    {
        //instance variables
        private int data;
        private Node head;
        private Node tail;
        private Node next;
        private Node prev;

        //constructors
        Node (int newData)
        {
            this.data = newData;
        }

        //getters
        public int getData()
        {
            return data;
        }

        public Node getPrev()
        {
            return prev;
        }

        public Node getNext()
        {
            return next;
        }

        public Node getHead(){ return head; }

        public Node getTail(){ return tail; }

        //setters
        public void setData(int data) {
            this.data = data;
        }

        public void setPrev() {
            this.prev = prev;
        }

        public void setNext() {
            this.next = next;
        }

        public void setHead() { this.head = head; }

        public void setTail() { this.tail = tail; }


        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        //toStrings
        public String prevToString()
        {
            return "data: " + data + " links to " + prev;
        }

        public String nextToString()
        {
            return "data: " + data + " links to " + next;
        }
    }//end of class Node
}//end of main class DoublyLL