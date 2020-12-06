package calculator.view;

public class CalculateOutView {
    private static final String RESULT_MESSAGE = "= %d";
    public static void showResult(int result) {
        System.out.println(String.format(RESULT_MESSAGE, result));
    }
}
