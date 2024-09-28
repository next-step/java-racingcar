package calculator;

public class StringCalculator {


    public static int splitAndSum(final String input){
        if (isStringEmpty(input)){
            return 0;
        }

        return parseStringToInt(input);
    }

    private static Boolean isStringEmpty(final String input){
        return input == null || input.isBlank();
    }

    private static Integer parseStringToInt(final String input) {
        return Integer.parseInt(input);
    }
}
