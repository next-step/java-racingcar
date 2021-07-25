package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public int calculateFromString(String input) {
        List<String> strings = Arrays.asList(input.split(" "));
        int size = strings.size();
        if (size < 3) {
            throw new IllegalArgumentException();
        }
        Operator operator;
        int num2;
        int answer = Integer.parseInt(strings.get(0));
        for (int i = 1; i < size - 1; i += 2) {
            operator = Operator.valueOfString(strings.get(i));
            num2 = Integer.parseInt(strings.get(i + 1));
            if (operator.equals(Operator.DIV) && num2 == 0) {
                throw new IllegalArgumentException();
            }
            answer = operator.execute(answer, num2);
        }
        return answer;
    }
}
