package racingcar.service;

import java.util.Arrays;
import java.util.function.Function;

public enum Operation {
    GO("1", (locationInfo) -> locationInfo + 1),
    STOP("0", (locationInfo) -> locationInfo);

    private String operator;
    private Function<Integer, Integer> expression;

    Operation(String operator, Function<Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }
    public static Integer result(String check, Integer locationInfo){
        return findBySymbol(check).expression.apply(locationInfo);
    }
    public static Operation findBySymbol(String check){
        return Arrays.stream(Operation.values())
                .filter(Operation -> Operation.operator.equals(check))
                .findFirst()
                .orElse(null);
    }

}
