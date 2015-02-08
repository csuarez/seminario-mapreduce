import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Standard implementation of GreekGodCounter
 * @author csuarez
 */
public class GreekGodCounterStandard {
    
    private final static String[] gods = {
        "Zeus",
        "Hera",
        "Poseidón",
        "Dioniso",
        "Apolo",
        "Artemisa",
        "Hermes",
        "Atenea",
        "Ares",
        "Afrodita",
        "Hefesto",
        "Deméter"
    };

    /**
     * Main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        HashMap<String, Integer> godMap = new HashMap<>();
        
        //Initializing the initial structure
        for (String god : gods) {
            godMap.put(god, 0);
        }
        
        try {
            //Reading input
            br = new BufferedReader(new FileReader(args[0]));
            String line = br.readLine();
            while (line != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    if (godMap.containsKey(token)) {
                        godMap.put(token, godMap.get(token) + 1);
                    }
                }
                line = br.readLine();
            }
            
            //Writing output
            Writer writer = new BufferedWriter(new FileWriter("gods.txt"));
            for (Entry<String, Integer> entry : godMap.entrySet()) {
                writer.write(entry.getKey() + " = " + entry.getValue());
                writer.write(System.lineSeparator());
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GreekGodCounterStandard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GreekGodCounterStandard.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(GreekGodCounterStandard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
