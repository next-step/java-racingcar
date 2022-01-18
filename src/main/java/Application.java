import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        UserInput userInput = new UserInput();
        Seperator seperator = new Seperator();
        seperator.seperate(userInput.list);
        seperator.print();
        //userInput.printList();
    }
}
