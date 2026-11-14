package calculator;

public class Calculator {


    public static int sum(String input) {
        int sum = 0;

        if (isEmpty(input)) return 0;

        for (String s : input.split("[,:]")) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }
}
