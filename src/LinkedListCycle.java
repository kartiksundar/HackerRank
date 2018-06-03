import LinkedList.LinkedList;
import LinkedList.Node;

public class LinkedListCycle
{
    public static void main(String[] args) {
        LinkedList ls = createLinkedList();
        ls.print();
        System.out.println("Has Cycle " + hasCycle(ls.head));
        ls.createCycle(2);
        System.out.println("Has Cycle " + hasCycle(ls.head));
    }

    private static LinkedList createLinkedList()
    {
        LinkedList ls = new LinkedList();
        ls.append(1);
        ls.append(2);
        ls.append(3);
        ls.append(4);
        ls.append(5);
        ls.append(4);
        return ls;
    }

    /**
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(Node head) {
        if (head == null)
            return false;

        Node fast = head.next;
        Node slow = head;

        while (fast != null && fast.next != null && slow != null)
        {
            if (fast == slow) return true;

            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}

