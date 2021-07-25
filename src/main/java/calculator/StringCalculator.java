package calculator;

import calculator.exception.InputBlankException;

import java.util.Deque;
import java.util.LinkedList;

public class StringCalculator {
    private Deque<String> calculateElements;
    private static final String BLANK = " ";

    public StringCalculator(String input) {
        calculateElements = new LinkedList<>();
        checkInputBlank(input);
        initCalculateElements(input);
    }

    private void initCalculateElements(String input) {

        String[] calculateStringList = input.split(BLANK);

        for (String currentString : calculateStringList) {
            calculateElements.add(currentString);
        }
    }

    private void checkInputBlank(String input) {
        if (input == null || input.trim() == "") {
            throw new InputBlankException();
        }
    }

    public String execute(String input) {
        String result = "";

        while (calculateElements.size() > 1) {
            String number1 = calculateElements.poll();
            StringOperatorEnum operator = StringOperatorEnum.of(calculateElements.poll());
            String number2 = calculateElements.poll();

            result = calculate(number1, number2, operator);
            calculateElements.addFirst(result);
        }

        return result;
    }

    private String calculate(String number1, String number2, StringOperatorEnum operator) {
        int num1 = Integer.parseInt(number1);
        int num2 = Integer.parseInt(number2);

        return operator.calculation(num1, num2);
    }
}
