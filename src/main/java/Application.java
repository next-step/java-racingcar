import common.UserInput;
import domain.Calculator;

import java.io.IOException;
import java.util.Calendar;

public class Application {
    public static void main(String[] args) throws IOException {
        UserInput input = new UserInput();

        Calculator calculator = Calculator.of(input.getSplitUserInput());


    }
}
