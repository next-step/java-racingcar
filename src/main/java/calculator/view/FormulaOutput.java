package calculator.view;

public class FormulaOutput {

    private FormulaOutput() {

    }

    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String ERROR_NULL_OR_EMPTY = "입력값이 Null이거나 빈 공백 문자입니다!";
    private static final String REQUEST_FORMULA_INPUT_MESSAGE = "계산할 연산식을 입력해주세요.";
    public static final String ERROR_NOT_OPERATOR = "사칙연산 기호가 아닙니다.";
    public static final String ERROR_NOT_NUMBER = "피연산자가 숫자가 아닙니다.";

    public static void printRequestFormula() {
        System.out.println(REQUEST_FORMULA_INPUT_MESSAGE);
    }

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(ERROR_MESSAGE + exceptionMessage);
    }

    public static void printFormulaResult(Double result) {
        System.out.println(result);
    }

}
