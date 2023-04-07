import java.util.Arrays;

public class StringAddCalculator {
    private StringAddCalculator(){}
    public static int splitAndSum(String input) {
        // validation
        try{
            InputValidator.validateNullOrEmpty(input);
        }catch (IllegalArgumentException e){
            return 0;
        }

        if(InputValidator.isOnlyNumber(input)) return Integer.parseInt(input);

        // parse
        String[] numbers = new NumberParser(input).parseNumbers();

        return getSum(numbers);
    }

    private static int getSum(String[] numbers){
        return Arrays.stream(numbers)
                .mapToInt(number -> {
                    try {
                        return getNumberFromString(number);
                    } catch (IllegalArgumentException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                })
                .sum();
    }

    private static int getNumberFromString(String number) {
        InputValidator.isPositive(number);
        return Integer.parseInt(number);
    }
}
