package study;

public class Calculator {
    public static int calculate(String s) {
        String[] values = s.split(" ");
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);
        String operator = values[1];

        if("+".equals(operator)) {
            return first + second;
        }
        if("-".equals(operator)) {
            return first - second;
        }
        if("*".equals(operator)) {
            return first * second;
        }
        if("/".equals(operator)) {
            return first / second;
        }

        return 0;
    }
}
