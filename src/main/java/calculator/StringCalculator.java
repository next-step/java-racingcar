package calculator;

public class StringCalculator {


    public static int splitAndSum(final String input){
        if (isStringEmpty(input)){
            return 0;
        }

        String[] inputSplit = input.split(",");
        int result = 0;
        for (String s : inputSplit) {
            result += parseStringToInt(s);
        }

        return result;
    }

    private static Boolean isStringEmpty(final String input){
        return input == null || input.isBlank();
    }

    private static Integer parseStringToInt(final String input) {
        return Integer.parseInt(input);
    }
}
