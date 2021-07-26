package racingcar.step4;

public class Application {
    public static void main(String[] args) {
        String strLiterals = InputView.InputCarNames();
        Validation.checkForNull(strLiterals);
        int tryCount = InputView.InputTryCount();
        Validation.checkValidTryCount(tryCount);


    }
}
