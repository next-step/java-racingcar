import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        UserInput userInput = new UserInput();
        Seperator seperator = new Seperator();
        seperator.seperate(userInput.inputList);
        Calculator calculator = new Calculator();

        float result = calculator.doMultipleOperation(seperator.number.numbers, seperator.operator.operators);
        System.out.println(result);
    }
}
