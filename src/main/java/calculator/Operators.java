package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Operators {
    private final Queue<Operator> operators;


    public Operators(List<String> strs) {
        this.operators = strs.stream()
                .map(Operator::fromOpChar)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public Operator poll() {
        return this.operators.poll();
    }

    public boolean isEmpty() {
        return operators.isEmpty();
    }
}

