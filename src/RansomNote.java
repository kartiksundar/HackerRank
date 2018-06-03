import java.util.Hashtable;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class RansomNote
{
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] ransom = new String[n];

        String[] ransomItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String ransomItem = ransomItems[i];
            ransom[i] = ransomItem;
        }
        scanner.close();

        boolean contains = contains(magazine, ransom);

        System.out.println(contains ? "Yes" :"No");


    }

    /**
     * Performance is O(m + r)
     * @param magazine
     * @param ransom
     * @return
     */
    private static boolean contains(String[] magazine, String[] ransom)
    {
        Hashtable<String, AtomicInteger> map = new Hashtable<String, AtomicInteger>();

        for (String s: ransom)
        {
            AtomicInteger i = map.get(s);

            if (i != null)
                i.set(i.intValue() + 1);
            else
                map.put(s, new AtomicInteger(1));
        }

        for (int i = 0; i < magazine.length && !map.isEmpty(); i++)
        {
            AtomicInteger count = map.get(magazine[i]);

            if (count != null)
            {
                int newValue = count.intValue() - 1;
                if (newValue == 0)
                    map.remove(magazine[i]);
                else
                    count.set(newValue);
            }
        }

        return map.isEmpty();
    }
}
