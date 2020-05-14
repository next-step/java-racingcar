package study.step2_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Separator {

    private static final String DELIMITER =" ";

    private Separator() {
    }

    public static String [] separateByDelimiter(String expression){
        Validator.isBlank(expression);
        return expression.split(DELIMITER);
    }

    public static Calculation makeCalculation(String[] values) {
        Validator validator = new Validator(values);
        return new Calculation(validator.validateNumbers(separateNumber(values)), validator.validateOperator(separateOperator(values)));
    }

    private static List<String> separateOperator(String[] values) {
        return Arrays.stream(values)
                .filter(value -> Operator.isOperator(value))
                .collect(Collectors.toList());
    }

    private static List<Double> separateNumber(String[] values) {
        return Arrays.stream(values)
                .filter(value -> Validator.isNumber(value))
                .map(value -> Double.parseDouble(value))
                .collect(Collectors.toList());
    }
}