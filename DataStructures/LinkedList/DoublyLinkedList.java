package DataStructures.LinkedList;

/**
 * {@code DoublyLinkedList} is a variation of the <em>linked list</em>.
 * The linked list is a linear data structure which can be described
 * as the collection of nodes. Nodes are connected through pointers.
 * Each node contains two fields: data and pointer to the next field.
 * The first node of the linked list is called the head,
 * and the last node of the list is called the tail of the list.
 *<p>
 * One of the limitations of the singly linked list is that it can be
 * traversed in only one direction that is forward. The doubly linked list
 * has overcome this limitation by providing an additional pointer
 * that points to the previous node. With the help of the previous pointer,
 * the doubly linked list can be traversed in a backward direction
 * thus making <em>insertion</em> and <em>deletion</em> operations easier to perform.
 */
public class DoublyLinkedList<Item> {

    //Represent the head and tail of the doubly linked list
    private Node head;
    private Node tail;

    //Represent a node of the doubly linked list
    private class Node {
        private Item item;
        private Node previous;
        private Node next;
    }

    //addNode() will add a node to the list
    public void addNode(Item item) {
        //Create a new node
        Node newNode = new Node();
        newNode.item = item;

        //Checks if the list is empty
        if (head == null) {
            //Both head and tail will point to newNode
            head = tail = newNode;
            //head's previous will point to null
            head.previous = null;
            //As it is last node, tail's next will point to null
            tail.next = null;
        } else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode's previous will point to tail
            newNode.previous = tail;
            //newNode will become new tail
            tail = newNode;
            //As it is last node, tail's next will point to null
            tail.next = null;
        }
    }

    //display() will print out the nodes of the list
    public void display() {
        //Node current will point to head
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            //Prints each node by incrementing the pointer.
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

}

