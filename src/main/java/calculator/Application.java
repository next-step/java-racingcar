package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class Application {
    public void start() {
        ArrayDeque<String> expression = userInput();
        if (expression != null){
            Calculator calculator = new Calculator();
            Double result = calculator.calculate(expression);
            System.out.println(result);
        }
    }

    public ArrayDeque<String> userInput() {
        ArrayDeque<String> dequeInput = null;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in))) {
            String input = br.readLine();
            Validator.checkEmptyInput(input);
            dequeInput = stringToDeque(input);
            Validator.checkExpression(dequeInput);
            return dequeInput;
        } catch (IOException e) {
            System.out.println("Input Array");
        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();
        }
        return null;
    }

    public ArrayDeque<String> stringToDeque(String input) {
        List<String> stringList = Arrays.asList(input.split(" "));
        return new ArrayDeque<>(stringList);
    }
}
