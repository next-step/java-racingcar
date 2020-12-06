package calculator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Operators {

    private final List<Operator> operators;

    public Operators(List<String> strOperators) {
        this.operators = Collections.unmodifiableList(mapOperators(strOperators));
    }

    private static List<Operator> mapOperators(List<String> strOperators) {
        return strOperators.stream()
                .map(Operator::of)
                .collect(Collectors.toList());
    }

    public int size() {
        return operators.size();
    }

    public Operator get(int index) {
        return operators.get(index);
    }
}
