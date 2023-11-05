package study;

import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private final Splitter splitter;
    private final SumOperator sumOperator;

    public StringAddCalculator() {
        splitter = new Splitter();
        sumOperator = new SumOperator();
    }

    public int calculator(String text) {
        Parser parser = new Parser(text);
        List<String> numbers = splitter.split(parser.content(), parser.delimiter().value());
        return sumOperator.sum(numbers);
    }
}