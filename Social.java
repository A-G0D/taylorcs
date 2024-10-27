import java.util.*;
import java.io.*;

public class Social {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("Social.in"));
        int n = sc.nextInt();
        sc.nextLine();
        int res = 0;
        while (n-- > 0) {
            String s = sc.next();
            String t = sc.next();
            int v = sc.nextInt();
            if (t.equals("Games")) {
                res += v / 10;
            } else {
                res -= v / 10;
            }
        }
        System.out.println(res > 0 ? "Games" : "Boba");
    }
}