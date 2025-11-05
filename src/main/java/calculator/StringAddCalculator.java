package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        int sum = 0;
        String[] strArray = input.split(",||:");
        for (String str : strArray) {
            sum += Integer.parseInt(str);
        }
        return sum;
    }

}
