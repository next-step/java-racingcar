import common.UserInput;
import domain.Calculator;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        UserInput input = new UserInput();
        System.out.println(input.getUserInput());
        //Calculator calculator = Calculator.of();®
    }
}
