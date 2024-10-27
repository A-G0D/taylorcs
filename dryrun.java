import java.util.*;
import java.io.*;

public class dryrun {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("dryrun.in"));
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            System.out.println("Movie: " + sc.nextLine().trim());
        }
    }
}