package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\\n(.*)");
    private final Adder adder = new Adder();
    private final DefaultSplitter defaultSplitter = new DefaultSplitter();
    private final CustomSplitter customSplitter = new CustomSplitter();
    private final Parser parser = new Parser();

    public int calculate(String input){
        if (input == null || input.isBlank()){
            return 0;
        }
        List<String> numbers = new LinkedList<>();
        if (isCustomText(input)){
            numbers.addAll(0, List.of(customSplitter.split(input)));
        }
        if (!isCustomText(input)){
            numbers.addAll(List.of(defaultSplitter.split(input)));
        }
        if (checkNegative(numbers)){
            throw new RuntimeException("음수를 입력하셨습니다.");
        }
        return adder.sumInts(parser.parseInts(numbers));
    }

    private boolean isCustomText(String input){
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()){
            return true;
        }
        return false;
    }

    private boolean checkNegative(List<String> numbers){
        String minusSign = "-";
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).contains(minusSign)){
                return true;
            }
        }
        return false;
    }


}
