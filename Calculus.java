import java.util.*;
import java.io.*;

public class Calculus {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("Calculus.in"));
        
        ArrayList<Integer> l = new ArrayList<>(Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList());
        int firstPow = l.size();

        for (int i = 0; i < firstPow; i++) {
            int currPow = firstPow - i;
            int newPow = currPow - 1;
            int currCoeff = l.get(i);
            int newCoeff = currCoeff * currPow;
            String operator = "";
            if (i != 0 && newCoeff >= 0) operator = "+";
            String xPow = "";
            if (newPow > 0) xPow= "x^" + newPow;
            System.out.print(operator + newCoeff + xPow);
        }
    }
}