package calculator;

public class Calculator {
    public long calculate(String value) {
        int sum = 0;
        for (String val : value.split(",")) {
            sum += Integer.parseInt(val);
        }
        return sum;
    }
}
