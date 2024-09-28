package calculator;

public class StringCalculator {

    public static int sum(final String input){
        Integer x = isStringEmpty(input);
        if (x != null) return x;

        return Integer.parseInt(input);
    }

    private static Integer isStringEmpty(String input) {
        if (input == null){
            return 0;
        }

        if (input.isBlank()){
            return 0;
        }
        return null;
    }
}
