import java.util.*;
import java.io.*;

public class Scheduling {
    public static boolean any(boolean[] l) {
        boolean w = false;
        for (boolean b : l) {
            if (b) {
                w = true;
                break;
            }
        }
        return w;
    }
    public static boolean[] toBool(int[] l, int m) {
        boolean[] res = new boolean[l.length];
        for (int i = 0; i < l.length; i++) {
            res[i] = l[i] > m;
        }
        return res;
    }
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("Scheduling.in"));
        int n = sc.nextInt();
        sc.nextLine();
        boolean w = true;
        int l[] = new int[]{330, 270, 270};
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int h = sc.nextInt();
            int m = sc.nextInt();
            m = h * 60 + m;
            int idx = (i + 1) % 3;
            if (l[idx] > m) l[idx] -= m;
            else {
                if (!any(toBool(l, m))) {
                    w = false;
                    break;
                } else {
                    idx = (i + 1) % 3;
                    if (l[idx] > m) l[idx] -= m;
                    else {
                        idx = (idx + 1) % 3;
                        if (l[idx] > m) l[idx] -= m;
                    }
                }
            }
        }
        System.out.println(w ? "YES" : "NO");
    }
}