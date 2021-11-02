package racingcar_2step;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CalculatorUtil {

    public static List<String> list = Arrays.asList("+", "-", "*", "/");

    public static String[] blankSplit(String input) {
        return input.split(" ");
    }

    public static Stack<String> getStack(String[] input) {
        Stack<String> stack = new Stack<>();
        for (int i = input.length - 1; i >= 0; i--) {
            stack.push(input[i]);
        }
        return stack;
    }

}
