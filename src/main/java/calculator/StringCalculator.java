package calculator;

public class StringCalculator {

    public static int sum(final String input){
        if (input == null){
            return 0;
        }

        if (input.isBlank()){
            return 0;
        }

        return Integer.parseInt(input);
    }
}
