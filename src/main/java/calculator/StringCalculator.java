package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {

    public static final String BLANK = " ";

    public int calculate(String text) {
        return sumText(splitText(text));
    }

    private List<String> splitText (String text) {
        String[] textArr = text.split(BLANK);
        List<String> values = new ArrayList<>();
        Arrays.stream(textArr)
                .map(values::add)
                .collect(Collectors.toList());
        return values;
    }

    private int sumText(List<String> texts) {
        return IntStream.range(0, texts.size() / 2)
                .reduce(Integer.parseInt(texts.get(0)), (result, index) -> {
                    int operatorIndex = index * 2 + 1;
                    String operatorText = texts.get(operatorIndex);
                    int nextNumber = Integer.parseInt(texts.get(operatorIndex + 1));
                    return MathOperator.operate(operatorText, result, nextNumber);
                });
    }

}
