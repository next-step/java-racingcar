import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private String text;
    private String[] textArray;
    private List<String> operators = new ArrayList<>();
    private int result;

    public int getResult() {
        return result;
    }

    public StringCalculator() {}

    public StringCalculator(String text) {
        if (text == null || text.equals("")) {
            throw new IllegalArgumentException();
        }

        this.text = text;
        this.textArray = text.split(" ");
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

    public void checkOperator(String op) {
        if (op.matches("[^-+/*]")) {
            throw new IllegalArgumentException();
        }
    }

    public int calculate() {
        for (String s : textArray) {
            if (s.matches("\\d") && operators.size() > 0) {
                int a = Integer.parseInt(s);
                int temp = 0;
                String op = operators.remove(0);

                switch (op) {
                    case "+":
                        temp = add(result, a);
                        break;
                    case "-":
                        temp = subtract(result, a);
                        break;
                    case "*":
                        temp = multiply(result, a);
                        break;
                    case "/":
                        temp = divide(result, a);
                        break;
                }
                result = temp;
            } else if (s.matches("\\d+") && operators.size() == 0) {
                result += Integer.parseInt(s);
            } else {
                checkOperator(s);
                operators.add(s);
            }
        }
        return result;
    }
}