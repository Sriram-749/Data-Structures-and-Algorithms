public class SinglyLinkedListInsertion {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Method to insert at last position in a singly linked list

    void append(SinglyLinkedListInsertion list, int data) {

        Node newNode = new Node(data);

        if(list.head == null)
            list.head = newNode;

        else {
            Node currentNode = list.head;

            while(currentNode.next != null)
                currentNode = currentNode.next;

            currentNode.next = newNode;
        }
    }

    // Method to insert a node at the specified position
    
    void insertNode(SinglyLinkedListInsertion list, int data, int position) {

        Node newNode = new Node(data), currentNode = list.head, prevNode = null;

        if(list.head == null) {
            System.out.println("The current list is empty list. New node is inserted in the head position");
            list.head = newNode;
            return ;
        }
        
        while(currentNode != null && position - 1 >= 0) {
            position--;
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        prevNode.next = newNode;
        newNode.next = currentNode;
    }

    // Method to insert node at front of the list

    void insertFront(SinglyLinkedListInsertion list, int data) {

        Node newNode = new Node(data);

        if(list.head == null) {
            list.head = newNode;
        }

        else {
            newNode.next = list.head;
            list.head = newNode;
        }
    }

    void printList(SinglyLinkedListInsertion list) {

        Node currentNode = list.head;

        System.out.print("Your LinkedList is: ");

        while(currentNode != null) {
            System.out.print(currentNode.data + " --> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {

        SinglyLinkedListInsertion list = new SinglyLinkedListInsertion();

        // Calling the append method to insert the node at the end
        list.append(list, 1);
        list.append(list, 2);
        list.append(list, 3);
        list.append(list, 4);
        list.append(list, 5);

        // Calling the printList method to print the linked list
        list.printList(list);
        
        // Calling insetNode method to insert the node at specified index postion;
        list.insertNode(list, 6, 3);

        System.out.println("\nLinked List after inserting the node at index position 3: ");

        // Calling the printList method to print the linked list
        list.printList(list);

        // Calling insertFront to insert the node at front of linked list
        list.insertFront(list, 7);

        System.out.println("Linked List after inserting the node at front");

        // Calling the printList method to print the linked list
        list.printList(list);
    }
}