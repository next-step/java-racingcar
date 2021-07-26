package calculator;

import java.util.List;

public class Calculator {

    private List<Integer> inputs;

    public int calculate(String expression) {
        if(isBlank(expression)) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다.");
        }

        Extractor extractor = new Extractor(expression);

        List<Integer> numbers = extractor.getNumbers();
        List<Operator> operators = extractor.getOperators();

        int result = numbers.get(0);

        for(int i = 0; i < operators.size(); i++) {
            Integer y = numbers.get(i + 1);
            Operator operator = operators.get(i);

            result = operator.operate(result, y);
        }

        return result;
    }

    private boolean isBlank(String string) {
        return string == null || string.isEmpty();
    }

}
