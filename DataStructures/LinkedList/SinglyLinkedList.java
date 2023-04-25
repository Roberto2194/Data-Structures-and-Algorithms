package DataStructures.LinkedList;

/**
 * The {@code SinglyLinkedList} is a linear data structure in which each element
 * of the list contains a pointer which points to the next element in the list.
 * Each element in the singly linked list is called a <em>node</em>.
 * Each node has two components: data and a pointer next which points to the next node in the list.
 * The first node of the list is called as head, and the last node of the list is called a tail.
 * The last node of the list contains a pointer to the null.
 * Each node in the list can be accessed linearly by traversing through the list from head to tail.
 */
public class SinglyLinkedList<Item> {

    //Represent the head and tail of the singly linked list
    private Node head;
    private Node tail;

    //Represent a node of the singly linked list
    private class Node {
        private Item item;
        private Node next;
    }

    //addNode() will add a new node to the list
    public void addNode(Item item) {
        //Create a new node
        Node newNode = new Node();
        newNode.item = item;

        //Checks if the list is empty
        if (head == null) {
            //If list is empty, both head and tail will point to new node
            head = tail = newNode;
        } else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode will become new tail of the list
            tail = newNode;
        }
    }

    //display() will display all the nodes present in the list
    public void display() {
        //Node current will point to head
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Nodes of singly linked list: ");
        while (current != null) {
            //Prints each node by incrementing pointer
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

}

