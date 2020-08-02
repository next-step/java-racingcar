package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class StringCalculator {

    public int calculate(String text) {

        if(isBlank(text)){
            throw new IllegalArgumentException("입력에 0 또는 NULL 값을 넣을 수 없습니다.");
        }
        return sumText(splitText(text));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }


    private Queue<String> splitText (String text) {
        String[] values = text.split(" ");
        Queue<String> textQueue = new LinkedList<>();
        Arrays.stream(values).map(value -> textQueue.add(value)).collect(Collectors.toList());
        return textQueue;
    }

    private int sumText(Queue<String> textQueue) {
        int result = 0;
        while (!textQueue.isEmpty()) {
            String text = textQueue.poll();
            if(MathOperator.hasMathOperator(text)){
                String nextText = textQueue.poll();
                MathOperator mathOperator = MathOperator.findByMathOperatorCode(text);
                result = mathOperator.apply(result, Integer.parseInt(nextText));
            } else {
                result = Integer.parseInt(text);
            }
        }
        return result;
    }
}
