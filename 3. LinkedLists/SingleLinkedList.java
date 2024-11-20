import java.util.Scanner;

public class SingleLinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // 1. Insertion

    // Method to insert at last position in a singly linked list

    void append(SingleLinkedList list, int data) {

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
    
    void insertNode(SingleLinkedList list, int data, int position) {

        Node newNode = new Node(data), currentNode = list.head, previousNode = null;

        if(list.head == null) {
            System.out.println("The current list is empty list. New node is inserted in the head position");
            list.head = newNode;
            return ;
        }
        
        else if(position == 0) {
            newNode.next = list.head;
            list.head = newNode;
            return;
        }

        while(currentNode != null && position - 1 >= 0) {
            position--;
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if(currentNode == null && position > 0) {
            System.out.println("Oops! Can't insert a node at this index position\n");
            return ;
        }

        else if(currentNode == null)
            System.out.println("The element is appended at the end of the singly lined list\n");
            
        previousNode.next = newNode;
        newNode.next = currentNode;
    }

    // Method to insert node at front of the list

    void insertFront(SingleLinkedList list, int data) {

        Node newNode = new Node(data);

        if(list.head == null) {
            list.head = newNode;
        }

        else {
            newNode.next = list.head;
            list.head = newNode;
        }
    }

    // 2. Deletion

    // Method to delete a node at end of the linked list

    void deleteEnd(SingleLinkedList list) {
        Node currentNode = list.head, previousNode = null;

        if(list.head == null) {
            System.out.println("Oops! The list is already empty!\n");
            return ;
        }

        else if(list.head.next == null) {
            list.head = previousNode;
            return;
        }

        while(currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        previousNode.next = null;
    }

    // Method to delete a node at the beginning of the singly linked list

    void deleteFront(SingleLinkedList list) {
        if(list.head == null) {
            System.out.println("Opps! The list is already empty!\n");
            return ;
        }

        else if(list.head.next == null) {
            list.head = null;
            return ;
        }

        Node currentNode = list.head;

        list.head = list.head.next;
        currentNode.next = null;
    }

    // Method to delete a node at the specified index position in a singly Linked list

    void deleteNode(SingleLinkedList list, int position) {

        if(list.head == null) {
            System.out.println("Opps! The list is already empty!\n");
            return ;
        }

        Node currentNode = list.head;

        if(position == 0) {
            list.head = currentNode.next;
            currentNode.next = null;
            return ;
        }

        Node previousNode = null;

        while(currentNode != null && position - 1 >= 0) {
            position--;
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if(currentNode == null) {
            System.out.println("Oops! Can't delete the node at the given index postion\n");
            return ;
        }

        previousNode.next = currentNode.next;
        currentNode = null;
    }

    // Method to delete a node by key

    void deleteNodeByKey(SingleLinkedList list, int data) {
        if(list.head == null) {
            System.out.println("Opps! The list is already empty!\n");
            return ;
        }

        Node currentNode = list.head, previousNode = null;

        while(currentNode != null && currentNode.data != data) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if(currentNode == null) {
            System.out.println("Oops! Can't find the element. Please recheck you list\n");
            return ;
        }

        if(currentNode == list.head) {
            list.head = null;
            return ;
        }

        previousNode.next = currentNode.next;
        currentNode.next = null;

    }
    // Method to print the singly Linked list

    void printList(SingleLinkedList list) {

        Node currentNode = list.head;

        System.out.print("\nYour LinkedList is: ");

        while(currentNode != null) {
            System.out.print(currentNode.data + " --> ");
            currentNode = currentNode.next;
        }

        System.out.println("null\n");
    }

    public static void main(String args[]) {

        SingleLinkedList list = new SingleLinkedList();

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("Choose any operation: ");

            System.out.println("1 - Append a node");
            System.out.println("2 - Insert node at the beginning");
            System.out.println("3 - Insert node at the specified position");
            System.out.println("4 - Delete a node at end");
            System.out.println("5 - Delete a node a front");
            System.out.println("6 - Delete a node at the specified position");
            System.out.println("7 - Delete node by key");
            System.out.println("0 - To quit\n");

            System.out.print("Enter the operation number: ");

            int operator = sc.nextInt();

            if(operator == 0)
                break;

            switch(operator) {
                case 1: System.out.println("\nYou chose append operation");
                        list.printList(list);
                        System.out.print("Enter a number: ");
                        list.append(list, sc.nextInt());
                        list.printList(list);
                        break;

                case 2: System.out.println("\nYou have chosen to insert node at front");
                        list.printList(list);
                        System.out.print("Enter a number: ");
                        list.insertFront(list, sc.nextInt());
                        list.printList(list);
                        break;

                case 3: System.out.println("\nYou have chosen to insert node at specified position");
                        list.printList(list);
                        System.out.print("Enter a number: ");
                        int num = sc.nextInt();
                        System.out.print("Enter the insert position: ");
                        int position = sc.nextInt();
                        list.insertNode(list, num, position);
                        list.printList(list);
                        break;

                case 4: System.out.println("\nYou haven chosen to delete a node at end");
                        list.printList(list);
                        list.deleteEnd(list);
                        list.printList(list);
                        break;

                case 5: System.out.println("\nYou have chosen to delete a not front");
                        list.printList(list);
                        list.deleteFront(list);
                        list.printList(list);
                        break;

                case 6: System.out.println("\nYou have chosen to delete a node at specified position");
                        list.printList(list);
                        System.out.print("Enter the position number of the node you want to delete: ");
                        list.deleteNode(list, sc.nextInt());
                        list.printList(list);
                        break;

                case 7: System.out.println("\nYou have chosen to delete a node by key");
                        list.printList(list);
                        System.out.print("Enter the element you want to delete: ");
                        list.deleteNodeByKey(list, sc.nextInt());
                        list.printList(list);
                        break; 

                case 0: System.out.println("You have quit the program. Thanks for using!!");
                        sc.close();
                        break;
            }

        }
    }
}