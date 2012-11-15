import java.util.Scanner;
import java.util.ArrayList;

/** Apartment List Code Challenge
 * Path Normalization Program
 @author Sang Ho (Steve) Lee
*/
	
public class PathNormalizer {

    /** The file path normalizing program.
        Reads from the standard input, and outputs to the standard output. */
    public static void main(String[] args) {
        if (args.length != 0) {	
            usage();
            System.exit(1);
        }
        Scanner inp = new Scanner(System.in);
        inp.useDelimiter("/");
        normalize(inp);
    }
	
    /** Normalizes the file pathway from INP. */
    static void normalize(Scanner inp) {
        ArrayList<String> valid = new ArrayList<String>();
        while (inp.hasNext()) {
            String next = inp.next();
            if (!next.matches("\\.+")) {
                valid.add(next);
            }
            if (next.equals("..")) {
                valid.remove(valid.size() - 1);
            }
        }
        buildString(valid);
    }
	
    /** Builds and returns a string representing a normalized
        file pathway from the strings contained in STRINGLIST. */
    static void buildString(ArrayList<String> stringlist) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < stringlist.size() - 1; i++) {
            buffer.append(stringlist.get(i));
            buffer.append("/");
        }
        buffer.append(stringlist.get(stringlist.size() - 1));
        System.out.println(buffer.toString());
    }
	
    /** Prints the usage message to the system output. */
    static void usage() {
        String usage1 = "Input format error: Type java PathNormalizer, press ENTER."; 
        String usage2 = "Then type in desired FOLDER/FOLDER2/../FOLDER3/./FOLDER5";
        System.out.println(usage1 + usage2);
    }
}
