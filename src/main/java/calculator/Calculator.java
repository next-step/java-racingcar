package calculator;

public class Calculator {



    public static int sum(String input) {

        String[] split = input.split(",");

        int sum = 0;

        for (String s : split) {
            sum += Integer.parseInt(s);
        }


        return sum;

    }
}
