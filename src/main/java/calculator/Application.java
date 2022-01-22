package calculator;

import java.io.IOException;

public class Application {
    static String INPUT_MESSAGE = "계산식을 입력하세요 : ";
    static String OUTPUT_MESSAGE = "결과값 : ";

    public static void main(String[] args) throws IOException {
        System.out.print(INPUT_MESSAGE);
        UserInput userInput = new UserInput();

        Separator separator = new Separator();
        separator.separate(userInput.inputList);

        Number number = separator.getNumberInstance();
        Operator operator = separator.getOperatorInstance();

        Calculator calculator = new Calculator();

        double result = calculator.doMultipleOperation(number, operator);
        System.out.println(OUTPUT_MESSAGE + result);
    }
}
