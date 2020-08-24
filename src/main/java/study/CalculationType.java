package study;

import java.util.Arrays;
import java.util.Optional;

public enum CalculationType {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTYPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private String calculationString;
    public Calculation calculation;


    CalculationType(String calculationString, Calculation calculation) {
        this.calculationString = calculationString;
        this.calculation = calculation;
    }


    public static CalculationType checkCalculationType(String inputString) {
        Optional<CalculationType> cType = Arrays.stream(CalculationType.values()).filter(calculationType -> calculationType.calculationString.equals(inputString)).findFirst();
        return cType.orElseThrow(IllegalArgumentException::new);
    }

    public static int calculate(CalculationType calculator, int a, int b) {
        return calculator.calculation.calculate(a, b);
    }

}
