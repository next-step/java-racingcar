package calculator;

public class Calculator {


    public static int sum(String input) {
        int sum = 0;
        for (String s : input.split("[,:]")) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
