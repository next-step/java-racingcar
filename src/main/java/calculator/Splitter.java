package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {
    private List<MyNumber> myNumbers;
    private List<Operator> operators;

    public Splitter(String expression) {
        this.myNumbers = new ArrayList<>();
        this.operators = new ArrayList<>();
        this.split(expression);
    }

    public List<MyNumber> getMyNumbers() {
        return this.myNumbers;
    }

    public List<Operator> getOperators() {
        return this.operators;
    }

    public Splitter split(String expression) {
        validate(expression);

        String[] splitExpressions = expression.split(" ");
        this.myNumbers = Arrays.stream(splitExpressions)
                .filter(StringUtils::isNumeric)
                .map(MyNumber::new)
                .collect(Collectors.toList());

        this.operators = Arrays.stream(splitExpressions)
                .filter(StringUtils::isNotNumeric)
                .map(Operator::of)
                .collect(Collectors.toList());

        return this;
    }

    private void validate(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("invalid expression : " + expression);
        }
    }
}
