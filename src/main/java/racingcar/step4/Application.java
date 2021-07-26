package racingcar.step4;

public class Application {
    public static void main(String[] args) {
        try {
            String strLiterals = InputView.InputCarNames();
            Validation.checkForNull(strLiterals);
            int tryCount = InputView.InputTryCount();
            Validation.isValidInteger(tryCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
