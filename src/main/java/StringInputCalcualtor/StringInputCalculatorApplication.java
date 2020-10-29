package StringInputCalcualtor;

import java.math.BigDecimal;

public class StringInputCalculatorApplication {
    public static void main(String[] args) {

        ArgumentCollector argumentCollector = new ArgumentCollector(args);
        String input = argumentCollector.collect();
        StringInputClassifier stringInputClassifier = new StringInputClassifier();
        stringInputClassifier.input(input);

        SimpleCalculator simpleCalculator = new SimpleCalculator();
        BigDecimal result = simpleCalculator.operate(stringInputClassifier.getOperators(), stringInputClassifier.getOperands());
        System.out.println(result);
    }
}
