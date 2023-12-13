package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern INPUT_PATTERN = Pattern.compile("//(.*)\\n(.*)");
    Adder adder = new Adder();
    DefaultSplitter defaultSplitter = new DefaultSplitter();
    CustomSplitter customSplitter = new CustomSplitter();
    Parser parser = new Parser();

    public int calculate(String input){
        if (input == null || input.isBlank()){
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();

        if (matchPattern(input)){
            stringBuilder.append(Arrays.toString(customSplitter.split(input)));
        }
        if (!matchPattern(input)){
            stringBuilder.append(Arrays.toString(defaultSplitter.split(input)));
        }
        if (checkNegative(stringBuilder)){
            throw new RuntimeException("음수를 입력하셨습니다.");
        }
        return adder.sumInts(parser.parseInts(stringBuilder));
    }

    private boolean matchPattern(String input){
        Matcher matcher = INPUT_PATTERN.matcher(input);
        return matcher.find();
    }

    private boolean checkNegative(StringBuilder numbers){
        char minusSign = '-';

        for (int i = 0; i < numbers.length(); i++) {
            char number = numbers.charAt(i);
            if (number == minusSign){
                return true;
            }
        }
        return false;
    }


}
