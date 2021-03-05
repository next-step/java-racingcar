import java.util.HashSet;
import java.util.Set;

public class StringCalculator {

    private static final String DELIMITER = " ";
    private Set<String> opSet = new HashSet<>();
    private String text;
    private String[] textArray;
    private int result;

    public void checkText(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkOperator(String[] textArray) {
        for (int i = 1; i < textArray.length; i += 2) {
            if (!opSet.contains(textArray[i])) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void setText(String text) {
        checkText(text);
        checkOperator(text.split(DELIMITER));
        this.text = text;
        this.textArray = text.split(DELIMITER);
    }

    public int getResult() {
        return result;
    }

    public StringCalculator() {
        opSet.add("+");
        opSet.add("-");
        opSet.add("*");
        opSet.add("/");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int calculate() {
        result = Integer.parseInt(textArray[0]);
        int temp = 0;
        for (int i = 1; i < textArray.length; i += 2) {
            int nextNum = Integer.parseInt(textArray[i + 1]);

            switch (textArray[i]) {
                case "+":
                    temp = add(result, nextNum);
                case "-":
                    temp = subtract(result, nextNum);
                case "*":
                    temp = multiply(result, nextNum);
                case "/":
                    temp = divide(result, nextNum);
            }
            result += temp;
        }

        return result;
    }
}