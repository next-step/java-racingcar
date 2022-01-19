import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        UserInput userInput = new UserInput();
        Seperator seperator = new Seperator();
        seperator.seperate(userInput.inputList);
        seperator.print();
        Calculator calculator = new Calculator();

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        List<String> operators = new ArrayList<>(Arrays.asList("+", "+", "/"));

        System.out.println(calculator.doMultipleOperation(numbers, operators));
        //userInput.printList();
    }
}
