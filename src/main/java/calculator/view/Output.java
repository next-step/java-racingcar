package calculator.view;

public class Output {
    private static final String START_MESSAGE = "계산식을 입력하세요.";
    private static final String CALCULATE_RESULT = "계산 결과: ";

    public void startMessageOutput() {
        System.out.print(START_MESSAGE);
    }

    public void resultOutput(int result) {
        System.out.print(CALCULATE_RESULT + Integer.toString(result));
    }
}
