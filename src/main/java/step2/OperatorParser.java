package step2;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class OperatorParser implements Parser<Operator> {

    @Override
    public List<Operator> parse(List<String> elements) {
        return elements.stream()
                .filter(Operator::isSupport)
                .map(Operator::from)
                .collect(toList());
    }
}
