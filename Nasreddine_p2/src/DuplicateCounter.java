import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
 public class DuplicateCounter {
    private Map<String, Integer> wordCounter;
    public DuplicateCounter()
    {
        this.wordCounter = new HashMap<String, Integer>();
    }
    public void count(String dataFile)throws IOException
    {
        int count;
        FileReader input = new FileReader(dataFile);
        Scanner scnr = new Scanner(input);
        while (scnr.hasNext()) {
            String data = scnr.next();
            if(wordCounter.containsKey(data))
            {
                count= wordCounter.get(data)+1;
                wordCounter.put(data, count);
            }
            else
            {
                wordCounter.put(data,1);
            }
        }
        scnr.close();
        input.close();
    }
    public void write(String outputFile) throws IOException
    {
        BufferedWriter bwrite = null;
        FileWriter fwrite = null;
        try {
            fwrite = new FileWriter(outputFile);
            bwrite = new BufferedWriter(fwrite);
            for (Entry<String, Integer> entry : wordCounter.entrySet())
            {
                bwrite.write(entry.getKey() + " " + entry.getValue());
                bwrite.newLine();
            }
            System.out.println("\n\t\t\t\tInfo Written to text file : unique_word_counts.txt");

        } catch (IOException e) {
                e.printStackTrace();

          } finally
            {
            try {
                if (bwrite != null)
                    bwrite.close();
                if (fwrite != null)
                    fwrite.close();
            } catch (IOException ex)
               {
                 ex.printStackTrace();
               }
            }
    }
}