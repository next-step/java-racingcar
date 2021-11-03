package racingcar.step2.operation;

import java.util.Arrays;
import java.util.List;

public class Operations {

    private final List<Operation> operations;

    public Operations(String left, String right) {
        operations = Arrays.asList(new Sum(left, right), new Minus(left, right),
                new Multiply(left, right), new Divide(left, right));
    }

    public Operation getOperation(String sign) {
        return operations.stream()
                .filter(o -> o.isSign(sign))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
