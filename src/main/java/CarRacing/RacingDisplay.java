package CarRacing;

public class RacingDisplay {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    private static final CarRacing carRacing = new CarRacing();

    public static void main(String[] args) {
        int carNums = inputView.inputCarView();
        int moveNums = inputView.inputMoveView();

        ResultView.lineChange();
        ResultView.resultPrintResultComment();

        carRacing.race(carNums, moveNums);
    }
}
