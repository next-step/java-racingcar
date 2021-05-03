package calculator.view;

public class Output {
    private static final String START_MESSAGE = "계산식을 입력하세요.";
    private static final String CALCULATE_RESULT = "계산 결과: ";

    public static void outputStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void resultOutput(double result) {
        System.out.print(CALCULATE_RESULT);
        System.out.print(result);
    }
}