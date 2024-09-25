package calculator;

public class Calculator {
    public int sum(String input) {
        String[] split = input.split(":");

        int sum=0;
        for (String number : split) {
            sum+=Integer.parseInt(number);
        }
        return sum;
    }
}
