package step2;

import java.util.Arrays;

public class OperatorUtil {

    public static int operate(String operator, int first, int second) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.equalsValue(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported Operation : " + operator))
                .operate(first, second);
    }
}
