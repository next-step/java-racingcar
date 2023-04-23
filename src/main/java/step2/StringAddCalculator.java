package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringAddCalculator {

    public static final String REGEX = "//(.)\n(.*)";
    public static final String PATTERN_BASIC = ",|:";

    public int splitAndSum(String text) throws RuntimeException{

        if(checkNullOrEmpty(text)){
            return 0;
        }

        int[] numbers = makeNumberArr(text);
        checkContainNegative(numbers);
        return addNumbers(numbers);
    }

    private static void checkContainNegative(int[] numbers) {
        for (int number : numbers) {
            checkNegative(number);
        }
    }

    private static void checkNegative(int number) {
        if(number < 0){
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    private boolean checkNullOrEmpty(String text){
        return text == null || text.isEmpty();
    }

    private int addNumbers(int[] numbers){
        return IntStream.of(numbers).sum();
    }

    private int[] makeNumberArr(String text){
        String delimiter = "";
        String[] tokens;

        Matcher m = Pattern.compile(REGEX).matcher(text);
        if (m.find()) {
            delimiter = m.group(1);
            tokens = m.group(2).split(delimiter);
        } else{
            tokens = text.split(PATTERN_BASIC);
        }

        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}