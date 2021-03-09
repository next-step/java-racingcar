package calculator;

import exception.InvalidValueException;

import java.util.Scanner;

public class CalculatorMain {

    public void main() {
        Calculator calculator = new Calculator();
        Util util = new Util();

        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextLine()) {
            throw new InvalidValueException();
        }

        String inputValue = scanner.nextLine();
        String[] values = util.splitStringWithBlank(inputValue);

        int result = 0;

        for (int i=0; i< values.length; i++) {

            if (util.checkIsOddNumber(i)) {
                Integer.parseInt(values[i]);
            }
        }
    }
}
