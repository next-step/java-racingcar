package racingcar.service;

import java.util.Arrays;
import java.util.function.Function;

public enum Operation {
    GO("1", (locationInfo) -> locationInfo + "-"),
    STOP("0", (locationInfo) -> locationInfo);

    private String operator;
    private Function<String, String> expression;

    Operation(String operator, Function<String, String> expression) {
        this.operator = operator;
        this.expression = expression;
    }
    public static String result(String check, String locationInfo){
        return findBySymbol(check).expression.apply(locationInfo);
    }
    public static Operation findBySymbol(String check){
        return Arrays.stream(Operation.values())
                .filter(Operation -> Operation.operator.equals(check))
                .findFirst()
                .orElse(null);
    }

}
