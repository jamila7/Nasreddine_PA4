import java.io.IOException;
public class Application {

    public static void main(String[] args) throws IOException {
    	DuplicateCounter counting=new DuplicateCounter();
        counting.count("problem2.txt");
        counting.write("unique_word_counts.txt");


    }

}
