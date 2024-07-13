class DoubleLinkedList {
    Node head;

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    void appendNode(DoubleLinkedList list, int data) {
        
        Node newNode = new Node(data);

        if(list.head == null) {
            list.head = newNode;
            newNode.prev = null;
            newNode.next = null;
            return;
        }

        Node currentNode = list.head;

        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        newNode.prev = currentNode;
        newNode.next = null;
    }

    void insertFront(DoubleLinkedList list, int data) {

        Node newNode = new Node(data);

        if(list.head == null) {
            list.head = newNode;
            newNode.prev = null;
            newNode.next = null;
            System.out.println(list.head.prev);
            return;

        }

        newNode.next = list.head;
        list.head.prev = newNode;
        newNode.prev = null;
        list.head = newNode;
    }

    void insertNode(DoubleLinkedList list, int data, int position) {
        Node newNode = new Node(data);

        if(position == 0) {
            newNode.next = list.head;
            if(list.head != null) {
                list.head.prev = newNode;
            }
            
            list.head = newNode;
            return;
        }
        
        Node currentNode = list.head, prevNode = null;

        while(currentNode != null && position - 1 >= 0) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            position--;
        }

        if(currentNode == null && position > 0) {
            System.out.println("Sorry! can't insert the node");
            return;
        }

        if(currentNode == null) {
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = null;
            return;
        }

        newNode.next = prevNode.next;
        newNode.next.prev = newNode;
        prevNode.next = newNode;
        newNode.prev = prevNode;
    }

    void deleteEnd(DoubleLinkedList list) {
        if(list.head == null) {
            return;
        }

        if(list.head.next == null) {
            list.head = null;
            return;
        }

        Node currentNode = list.head, prevNode = null;
        while(currentNode.next != null) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        prevNode.next = null;
        currentNode = null;
    }

    void deleteFront(DoubleLinkedList list) {
        if(list.head == null) {
            return;
        }

        if(list.head.next == null) {
            list.head = null;
            return;
        }

        list.head = list.head.next;
        list.head.prev = null;
    }

    void printList(DoubleLinkedList list) {

        System.out.print("null");

        Node currentNode = list.head;

        while(currentNode != null) {
            if(currentNode.prev == null)
                System.out.print(" <-- ");

            System.out.print(currentNode.data);

            if(currentNode.next == null)
                System.out.print(" --> null");
            
            else 
                System.out.print(" <--> ");

            currentNode = currentNode.next;
        }
    }


    void deleteByKey(DoubleLinkedList list, int key) {
        if(list.head == null) {
            return;
        }

        Node currentNode = list.head, prevNode = null;
        while(currentNode != null && currentNode.data != key) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        if(currentNode == null) {
            return;
        }

        prevNode.next = currentNode.next;
        currentNode.next.prev = prevNode;
        currentNode = null;
    }
    public static void main(String args[]) {

        DoubleLinkedList list = new DoubleLinkedList();

        list.appendNode(list, 1);
        list.appendNode(list, 2);
        list.appendNode(list, 3);
        list.appendNode(list, 4);

        list.insertFront(list, 0);

        list.insertNode(list, 5, 5);

        list.printList(list);

        list.deleteEnd(list);

        System.out.println();

        list.printList(list);

        list.deleteFront(list);

        System.out.println();

        list.printList(list);

        list.deleteByKey(list, 1);

        System.out.println();

        list.printList(list);
    }
}
