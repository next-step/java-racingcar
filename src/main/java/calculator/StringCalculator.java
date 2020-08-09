package calculator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {

    public static final String ERROR_MSG_BLANK = "입력에 0 또는 NULL 값을 넣을 수 없습니다.";

    public int calculate(String text) {

        if(isBlank(text)){
            throw new IllegalArgumentException(ERROR_MSG_BLANK);
        }
        return sumText(splitText(text));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }


    private List<String> splitText (String text) {
        String[] values = text.split(" ");
        List<String> texts = new ArrayList<>();
        Arrays.stream(values).map(value -> texts.add(value)).collect(Collectors.toList());
        return texts;
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
