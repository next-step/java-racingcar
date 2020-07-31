import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divider(int a, int b) {
        return a / b;
    }

    public int calculate(String input) {
        if (input == null || input.isEmpty()) throw new IllegalArgumentException("입력 값을 넣어주세요.");

        String[] split = input.split(" ");

        int result = Integer.parseInt(split[0]);

        for (int i = 0; i < split.length; i++) {
            char c = split[i].charAt(0);
            if (Character.isDigit(c)) {
                continue;
            }
            int nextValue = Integer.parseInt(split[i+1]);
            switch (c) {
                case '+':
                    plus(result, nextValue);
                    break;
                case '-':
                    minus(result, nextValue);
                    break;
                case '*':
                    multiply(result, nextValue);
                    break;
                case '/':
                    divider(result, nextValue);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        return result;
    }
}
