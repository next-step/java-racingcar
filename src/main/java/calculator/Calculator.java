package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public int calculate(String expression) {

        checkBlank(expression);

        Separator separator = new Separator(expression);

        List<Integer> numbers = separator.getNumbers();
        List<Operator> operators = separator.getOperators();

        int result = numbers.get(0);

        for (int i = 0; i < operators.size(); i++){

            Integer nextNumber = numbers.get(i + 1);
            Operator operator = operators.get(i);

            result = operator.calculate(result, nextNumber);
        }

        return result;
    }


    public void checkBlank(String expression) {
        if(isBlank(expression)) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다.");
        }
    }

    public boolean isBlank(String string) {
        return string == null || string.isEmpty();
    }
}
