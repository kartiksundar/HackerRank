import java.nio.charset.CharacterCodingException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Anagram
{

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        String a = scanner.nextLine();

        String b = scanner.nextLine();

        scanner.close();

        int diff = difference(a,b);

        System.out.println(diff);
    }

    /**
     * Performance O(a+b)
     * @param a
     * @param b
     * @return
     */
    private static int difference(String a, String b)
    {
        int mismatch = 0;
        HashMap<Character, AtomicInteger> map = new HashMap<Character, AtomicInteger>();

        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();


        // Create a map for mismatches
        // Keep a count of all elements in first string
        for (char c: ac)
        {
            Character objC = new Character(c);
            AtomicInteger i = map.get(objC);

            if (i != null)
                i.set(i.intValue() + 1);
            else
                map.put(objC, new AtomicInteger(1));
        }

        //Loop through all elements in second string and remove from map if there is a match
        for (char c : bc)
        {
            Character objC = new Character(c);
            AtomicInteger i = map.get(objC);

            if (i != null)
            {
                int newValue = i.intValue() - 1;
                if (newValue == 0)
                    map.remove(objC);
                else
                    i.set(newValue);
            }
            else
                mismatch++;
        }

        for (AtomicInteger i : map.values())
        {
            mismatch += i.intValue();
        }
        return mismatch;
    }
}
