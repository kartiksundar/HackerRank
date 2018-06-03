package LinkedList;

public class LinkedList
{
    public Node head;
    public void append(int data)
    {
       if (head == null)
       {
           head = new Node(data);
           return;
       }
       Node current = head;
       while (current.next != null)
           current = current.next;

       current.next = new Node(data);
    }

    public void print()
    {
        Node current = head;
        while (current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void createCycle(int backValue)
    {
        if (head == null)
            return;

        // Go to last node
        Node current = head;
        Node back = null;
        while (current.next != null) {
            if (current.data == backValue)
                back = current;

            current = current.next;
        }

        //Link pointer of last node to back node
        current.next = back;
    }
}
