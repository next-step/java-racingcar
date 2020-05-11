package step2.calculator;

public class OperatorValidator {

    private OperatorValidator() {

    }

    static void checkValidOperator(String inputOperator) {
        for (Operator operator : Operator.values()) {
            String standardOperator = operator.getValue();
            isValidOperator(inputOperator, standardOperator);
        }
    }

    static void isValidOperator(String inputOperator, String standardOperator) {
        boolean isValidOperator = inputOperator.equals(standardOperator);
        if (isValidOperator != true) {
            throw new IllegalArgumentException();
        }
    }
}
