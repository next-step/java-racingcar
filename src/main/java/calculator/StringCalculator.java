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
        List<String> textList = new ArrayList<>();
        Arrays.stream(values).map(value -> textList.add(value)).collect(Collectors.toList());
        return textList;
    }

    private int sumText(List<String> textList) {
        return IntStream.range(0, textList.size() / 2)
                .reduce(Integer.parseInt(textList.get(0)), (result, index) -> {
                    int operatorIndex = index * 2 + 1;
                    String operatorText = textList.get(operatorIndex);
                    int nextNumber = Integer.parseInt(textList.get(operatorIndex + 1));
                    return MathOperator.operate(operatorText, result, nextNumber);
                });
    }
}
