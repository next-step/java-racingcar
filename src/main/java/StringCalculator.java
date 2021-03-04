import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private String text;
    private String[] textArray;
    private List<String> operators = new ArrayList<>();
    private int result;

    public StringCalculator(String text) {
        if (text == null || text.equals("")) {
            throw new IllegalArgumentException();
        }

        this.text = text;
        this.textArray = text.split(" ");
    }

    public void add(int a) {
        result += a;
    }

    public void subtract(int a) {
        result -= a;
    }

    public void multiply(int a) {
        result *= a;
    }

    public void divide(int a) {
        result /= a;
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
                String op = operators.remove(0);

                switch (op) {
                    case "+":
                        add(a);
                        break;
                    case "-":
                        subtract(a);
                        break;
                    case "*":
                        multiply(a);
                        break;
                    case "/":
                        divide(a);
                        break;
                }
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