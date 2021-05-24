package calculator.view;

public final class Output {
    private static final String START_MESSAGE = "계산식을 입력하세요.";
    private static final String CALCULATE_RESULT = "계산 결과: ";

    private Output() {

    }

    public static void startMessageOutput() {
        System.out.println(START_MESSAGE);
    }

    public static void resultOutput(double result) {
        System.out.print(CALCULATE_RESULT);
        System.out.print(result);
    }
}