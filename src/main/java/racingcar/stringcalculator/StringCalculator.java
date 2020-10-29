package racingcar.stringcalculator;

/**
 * Created : 2020-10-29 오후 2:33
 * Developer : Seo
 */
public class StringCalculator {

    public int plus(String s1, String s2) {
        return Integer.parseInt(s1) + Integer.parseInt(s2);
    }

    public int minus(String s1, String s2) {
        return Integer.parseInt(s1) - Integer.parseInt(s2);
    }

    public int multiply(String s1, String s2) {
        return Integer.parseInt(s1) * Integer.parseInt(s2);
    }

    public int divide(String s1, String s2) {
        return Integer.parseInt(s1) / Integer.parseInt(s2);
    }

    public boolean isOperator(String s) {
        if (!"+".equals(s) && !"-".equals(s) && !"*".equals(s) && !"/".equals(s)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int calculate(String s) {
        String[] arr = s.split(" ");
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                sum = plus(String.valueOf(sum), arr[i]);
                continue;
            }

            if (isNumeric(arr[i]) && isOperator(arr[i - 1])) {
                switch (arr[i - 1]) {
                    case "+" : sum = plus(String.valueOf(sum), arr[i]); break;
                    case "-" : sum = minus(String.valueOf(sum), arr[i]); break;
                    case "*" : sum = multiply(String.valueOf(sum), arr[i]); break;
                    case "/" : sum = divide(String.valueOf(sum), arr[i]); break;
                    default: break;
                }
            }
        }
        return sum;
    }


}
