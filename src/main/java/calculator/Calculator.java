package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Calculator {


    private int tmpNumber;


    public Calculator() {
        tmpNumber = 0;
    }

    public int excute(String strings) {
        String[] stringLst = strings.split(" ");
        Queue<Integer> numbers = Arrays.stream(stringLst).filter(StringUtils::isNumeric).map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
        Queue<String> separators = Arrays.stream(stringLst).filter(i -> !StringUtils.isNumeric(i)).collect(Collectors.toCollection(LinkedList::new));

        return   calcute(numbers, separators);
    }


    private int calcute(Queue<Integer> numbers, Queue<String> separators) {
        tmpNumber = numbers.poll();
        separators.forEach(separator -> process(numbers.poll(), separator));

        return tmpNumber;
    }

    private void eval(int number, String cal) {
        switch (cal) {
            case ("+"):
                tmpNumber = add(tmpNumber, number);
                break;
            case ("-"):
                tmpNumber = subtract(tmpNumber, number);
                break;
            case ("*"):
                tmpNumber = multiply(tmpNumber, number);
                break;
            case ("/"):
                tmpNumber = divide(tmpNumber, number);
                break;
        }
    }

    private void process(int value, String separator) {
        eval(value, separator);
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static int divide(int a, int b) {
        return a / b;
    }
}

