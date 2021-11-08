package step2;

import java.util.List;

public class Calculator {
    public static int calculate(String expression) {
        String[] elements = expression.split(" ");
        int first = Integer.parseInt(elements[0]);
        int second = Integer.parseInt(elements[2]);
        return first + second;
    }
}
