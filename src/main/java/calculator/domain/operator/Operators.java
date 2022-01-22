package calculator.domain.operator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operators {
    private final List<Operator> operators;
    private final Map<String, Operator> map;

    public Operators() {
        this.operators = new ArrayList<>();
        this.map = new HashMap<>();

        initOperatorMap();
    }

    public void add(Operator element) {
        if (element == null) {
            throw new IllegalArgumentException("올바르지 않은 연산 기호입니다.");
        }
        operators.add(element);
    }

    public List<Operator> get() {
        return operators;
    }

    public Operator get(int index) {
        return operators.get(index);
    }

    public Map<String, Operator> map() {
        return map;
    }

    private void initOperatorMap() {
        map.put("+", new Plus());
        map.put("-", new Minus());
        map.put("*", new Multiply());
        map.put("/", new Divide());
    }
}
