package calculator;

import calculator.delimiter.Delimiter;
import calculator.delimiter.DelimiterFactory;
import calculator.operator.Operator;
import study.PositiveNumber;

import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public int cal(String text, Operator operator) {

        if (empty(text)) {
            return 0;
        }

        DelimiterFactory delimiterFactory = new DelimiterFactory();
        Delimiter delimiter = delimiterFactory.createDelimiter(text);
        List<String> texts = delimiter.parse(text);

        List<Integer> numbers = convertPositiveNumbers(texts);

        return operator.cal(numbers);
    }

    public List<Integer> convertPositiveNumbers(List<String> numbers) {
        return numbers.stream()
                .map(PositiveNumber::new)
                .mapToInt(PositiveNumber::value)
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean empty(String text) {
        return text == null || text.isBlank();
    }
}