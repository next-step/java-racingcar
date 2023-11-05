package calculator;

import calculator.delimiter.Delimiter;
import calculator.delimiter.DelimiterFactory;

import java.util.List;

public class Calculator {

    public int cal(String text) {

        if (empty(text)) {
            return 0;
        }

        DelimiterFactory delimiterFactory = new DelimiterFactory();
        Delimiter delimiter = delimiterFactory.createDelimiter(text);
        List<String> texts = delimiter.parse(text);


        return 0;
    }

    private boolean empty(String text) {
        return text == null || text.isBlank();
    }
}