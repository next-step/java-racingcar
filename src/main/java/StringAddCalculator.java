import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String SEPARATE_STRING = ",|:";
    private static final String CUSTOM_SEPARATE_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if(isEmpty(input)) return 0;
        int[] separateResult = separateInputToIntArray(input);
        negativeValidator(separateResult);

        return Arrays.stream(separateResult)
                .sum();
    }

    private static void negativeValidator(int[] targets){
        if(hasNegative(targets)){
            throw new RuntimeException();
        }
    }

    private static boolean hasNegative(int[] separateResult) {
        return Arrays.stream(separateResult).anyMatch(i -> i < 0);
    }

    private static int[] separateInputToIntArray(String input){
        Matcher matcher = separateByRegex(input);
        if(matcher.find()){
            return Arrays.stream(matcher.group(2)
                    .split(matcher.group(1)))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return Arrays.stream(input
                .split(SEPARATE_STRING))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static boolean isEmpty(String input){
        return input == null || input.isEmpty();
    }

    private static Matcher separateByRegex(String input) {
        return Pattern.compile(CUSTOM_SEPARATE_REGEX).matcher(input);
    }
}
