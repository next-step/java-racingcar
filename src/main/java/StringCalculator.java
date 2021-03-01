import java.util.HashMap;
import java.util.Map;

public class StringCalculator {
    public int add(int left, int right) {
        return left + right;
    }

    public int subtract(int left, int right) {
        return left - right;
    }

    public int multiply(int left, int right) {
        return left * right;
    }

    public int divide(int left, int right) {
        return left / right;
    }

    public int calculate(String params) {
        if (params == null || params.length() == 0) throw new IllegalArgumentException("Unvalid parameter");
        String[] strings = params.split(" ");
        int result = Integer.parseInt(strings[0]);
        int index = 1;
        while (index < strings.length) {
            if (strings[index].equals("+")) {
                result = add(result, Integer.parseInt(strings[index+1]));
                index += 1;
            }
            if (strings[index].equals("-")) {
                result = subtract(result, Integer.parseInt(strings[index+1]));
                index += 1;
            }
            if (strings[index].equals("*")) {
                result = multiply(result, Integer.parseInt(strings[index+1]));
                index += 1;
            }
            if (strings[index].equals("/")) {
                result = divide(result, Integer.parseInt(strings[index+1]));
                index += 1;
            }
            int i = Integer.parseInt(strings[index]);
            System.out.println(i);
            index++;
        }
        return result;
    }
}
