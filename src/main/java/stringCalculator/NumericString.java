package stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class NumericString {

    private String numericString;
    private final static String COMMA_OR_COLON_DELIMITER = ",|:";
    private final static String CUSTOM_DELIMITER = "//(.)\\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);
    private static final String POSITIVE_INTEGER_REGEX = "[0-9]+";
    private static final Pattern POSITIVE_INTEGER_PATTERN = Pattern.compile(POSITIVE_INTEGER_REGEX);

    public NumericString(String numericString){
        this.numericString = numericString;
    }

    public boolean nullOrEmpty(){
        return numericString == null || numericString.isEmpty();
    }

    public int sum(){
        int[] ints = splitToInts();
        return IntStream.of(ints).sum();
    }

    public int[] splitToInts(){
        return toInts(split());
    }

    private String[] split() {
        if(isCustomDelimiter()){
            return splitByCustomDelimiter();
        }
        return splitByCommaOrColonDelimiter();
    }

    private int[] toInts(String[] numbers){
        int[] ints = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            ints[i] = parseInt(numbers[i]);
        }
        return ints;
    }

    private int parseInt(String number){
        isPositive(number);
        return Integer.parseInt(number);
    }

    private boolean isCustomDelimiter(){
        return numericString.startsWith("//");
    }

    private String[] splitByCommaOrColonDelimiter(){
        return numericString.split(COMMA_OR_COLON_DELIMITER);
    }

    private String[] splitByCustomDelimiter(){
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(numericString);
        m.find();
        String customDelimiter = m.group(1);
        return m.group(2).split(customDelimiter);
    }

    private void isPositive(String number){
        if(!POSITIVE_INTEGER_PATTERN.matcher(number).matches()){
            throw new RuntimeException("음수는 입력될 수 없습니다.");
        }
    }
}
