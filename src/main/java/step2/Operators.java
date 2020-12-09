package step2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Operators {

    private List<Operator> operators;

    public Operators(List<String> text) {
        this.operators = text.stream()
                .map(Operator::getOperatorFor)
                .collect(Collectors.toList());
    }

    public Operator get(int index) {
        return operators.get(index);
    }

    public int size() {
        return this.operators.size();
    }

}
