import java.util.Arrays;

public class StrCalculator {
    String sum(String a, String b) {
        int intA = Integer.parseInt(a), intB = Integer.parseInt(b);
        int result = intA + intB;

        return Integer.toString(result);
    }

    String sub(String a, String b) {
        int intA = Integer.parseInt(a), intB = Integer.parseInt(b);
        int result = intA - intB;

        return Integer.toString(result);
    }

    String multi(String a, String b) {
        int intA = Integer.parseInt(a), intB = Integer.parseInt(b);
        int result = intA * intB;

        return Integer.toString(result);
    }

    String div(String a, String b) {
        int intA = Integer.parseInt(a), intB = Integer.parseInt(b);

        if (intB == 0) {
            throw new IllegalArgumentException("divided by 0.");
        }
        int result = intA / intB;

        return Integer.toString(result);
    }

    void checkExpression(String expr) {
        if (expr == null || expr.isEmpty()) {
            throw new IllegalArgumentException("expression is empty");
        }
    }

    String[] separation(String[] list) {
        return Arrays.copyOfRange(list, 0, 3);
    }

    void calOneByOne(String[] subList) {

    }
}
