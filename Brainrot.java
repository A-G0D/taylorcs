import java.util.*;
import java.io.*;

public class Brainrot {
    public static String shift(String s, int o) {
        StringBuilder res = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!Character.isAlphabetic(ch) || !Character.isLowerCase(ch)) {
                return s;
            } else {
                char shiftedChar = (char) ((ch - 'a' + o) % 26 + 'a');
                res.append(shiftedChar);
            }
        }
        return res.toString();
    }

    public static ArrayList<String> repl(ArrayList<String> sl) {
        ArrayList<String> res = new ArrayList<>();
        for (String word : sl) {
            boolean w = false;
            for (int dist = 1; dist < 26; dist++) {
                String shifted = shift(word, dist);
                if (shifted.equals("skibidi") || shifted.equals("rizz") || shifted.equals("sigma") || shifted.equals("gyatt")) {
                    res.add(shifted);
                    w = true;
                    break;
                }
            }
            if (!w) {
                res.add(word);
            }
        }
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("Brainrot.in"));
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            ArrayList<String> l = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
            System.out.println(String.join(" ", repl(l)));
        }
    }
}