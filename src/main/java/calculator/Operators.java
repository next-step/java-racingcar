package calculator;

import java.util.ArrayList;
import java.util.List;

public class Operators {
    private final List<Operator> operators = new ArrayList<>();;

    public Operators(String[] inputArray) {
        for (int i = 1; i < inputArray.length; i += 2) {
            operators.add(Operator.getOperator(inputArray[i]));
        }
    }

    public Operator get(int index) {
        return operators.get(index);
    }
}
