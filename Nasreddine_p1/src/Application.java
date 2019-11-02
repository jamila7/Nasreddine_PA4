import java.io.IOException;
public class Application {

    public static void main(String[] args) throws IOException {
    	DuplicateRemover problem1=new DuplicateRemover();
    	problem1.remove("problem1.txt");
    	problem1.Write("unique_words.txt");
    }
}
