import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.*;
public class DuplicateRemover {
    private Set<String> uniqueWords = new HashSet<String>();
    public void remove(String dataFile) throws IOException
    {
    	FileReader input = new FileReader(dataFile);
        Scanner scnr = new Scanner(input);
        String data = "";
        while(scnr.hasNext())
        {
            data=scnr.next();
            uniqueWords.add(data);
        }
        scnr.close();
        input.close();
    }
    public void Write(String outputFile) throws IOException
    {
        BufferedWriter bwrite = null;
        FileWriter fwrite = null;
        try {
            fwrite = new FileWriter(outputFile);
            bwrite = new BufferedWriter(fwrite);
            Iterator <String> words = uniqueWords.iterator();
            while (words.hasNext()) {

                bwrite.write((String) words.next());
                bwrite.newLine();
            }

            System.out.println("\n\t\t\tInfo Written to text file : unique_words.txt");
        } catch (IOException e) {

            e.printStackTrace();

        } finally {
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
