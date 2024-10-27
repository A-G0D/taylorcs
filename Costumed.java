import java.util.*;
import java.io.*;

class tuple<X, Y, Z> { 
    public X x; 
    public Y y; 
    public Z z;
    public tuple(X x, Y y, Z z) { 
      this.x = x; 
      this.y = y; 
      this.z = z;
    } 
  } 

public class Costumed {
        public static boolean match(tuple<String, String, String> a, tuple<String, Integer, String> b) {
            boolean persIsUnderClass = Arrays.asList("Skeleton", "Zombie", "Witch").contains(a.x);
            boolean susIsUnderClass = b.y < 11;
            boolean persIsBoy = a.y.equals("Pumpkin");
            boolean susIsBoy = b.z.equals("Boy");
            boolean persIsTaylor = Arrays.asList("Kit-Kats", "Jolly Ranchers", "Hershey Kisses").contains(a.z);
            boolean susIsTaylor = b.x.equals("Taylor");
            return (persIsUnderClass == susIsUnderClass) && (persIsBoy == susIsBoy) && (persIsTaylor == susIsTaylor);
        }

        public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("Costumed.in"));
        ArrayList<tuple<String, String, String>> people = new ArrayList<>();
        ArrayList<tuple<String, Integer, String>> suspects = new ArrayList<>();

        int np = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < np; i++) {
            String[] lp = sc.nextLine().split(" ");
            String costume = lp[0];
            String holding = lp[1];
            String snack = String.join(" ", Arrays.copyOfRange(lp, 2, lp.length));
            people.add(new tuple<String, String, String>(costume, holding, snack));
        }

        int ns = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < ns; i++) {
            String[] ls = sc.nextLine().split(" ");
            String name = ls[0];
            String school = String.join(" ", Arrays.copyOfRange(ls, 1, ls.length - 2));
            int grade = Integer.parseInt(ls[ls.length - 2]);
            String gender = ls[ls.length - 1];
            suspects.add(new tuple<String, Integer, String>(school, grade, gender));
        }

        for (int i = 0; i < people.size(); i++) {
            try {
                tuple<String, String, String> person = people.get(i);
                boolean matches = false;
                for (tuple<String, Integer, String> suspect : suspects) {
                    if (match(person, suspect)) {
                        matches = true;
                        break;
                    }
                }
                if (!matches) {
                    people.remove(i);
                    i--;
                }
            } catch (Exception E) {
                break;
            }
        }
        System.out.println(people.size());
    }
}