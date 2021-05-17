package calculator;

import java.util.List;

public class Calculator {
    public int calculate(String sentence) {
        BlankEraser blankEraser = new BlankEraser();
        String[] strings = blankEraser.erase(sentence);

        Extractor extractor = new Extractor();
        List<Integer> numbers = extractor.extractNumbers(strings);
        List<String> operators = extractor.extractOperators(strings);

        int result = 0;
        Operator operator = new Operator("+");
        for (int i = 0; i < numbers.size(); i++) {
            result = operator.operate(result, numbers.get(i));

            if (i != numbers.size() - 1) {
                operator = new Operator(operators.get(i));
            }
        }

        return result;
    }
}
