import java.util.Scanner;
import java.io.*;

public class ArrayLeftRotation
{
    /**
     * Rotate Left by copying into new array - O(n)
     * @param a
     * @param d
     * @return
     */
    static int[] rotLeft1(int[] a, int d)
    {
        if (d == 0 || d == a.length)
            return a;

        int[] temp = new int[a.length];

        // Copy elements starting at d postion till end of list
        for(int i = 0; i< (a.length-d);i++)
            temp[i] = a[i+d];

        // Copy elements from beginning of the list to d-1 position
        for(int i = 0; i < d; i++)
            temp[i+(a.length-d)] = a[i];

        return temp;
    }

    /**
     * Rotate Left Brute Force - O(d*n)
     * @param a
     * @param d
     * @return
     */
    static int[] rotLeftBruftForce(int[] a, int d)
    {
        if (d == 0 || d == a.length)
            return a;

        for (int i = 0; i < d; i++) {
            int temp = a[0];
            for (int j = 0; j < a.length-1; j++) {
                a[j] = a[j+1];
            }
            a[a.length-1] = temp;
        }

        return a;
    }

    /**
     * Rotate Left Brute Force - O(d*n)
     * @param a
     * @param d
     * @return
     */
    static int[] rotLeft(int[] a, int d)
    {
        int n = a.length;

        if (d == 0 || d == n)
            return a;

        int diff = n-d;

        // 1. d elements will be moved to the end
        // 2. Copy d elements to temp space
        // 3. Move n-d elemets to the left
        // 4. Copy temp space to the right

        int[] temp = new int[d];

        for (int i = 0; i < d; i++) {
            temp[i] = a[i];
        }

        for (int i = 0; i < diff; i++) {
            a[i] = a[i+d];
        }

        for (int i = diff; i < n; i++) {
            a[i] = temp[i-diff];
        }

        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];
        int[] b = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
            b[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        result = rotLeftBruftForce(b, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
