package carracing;

public class RacingDisplay {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    private static final RacingCar RACING_CAR = new RacingCar();

    public static void main(String[] args) {
        int carNums = inputView.inputCarView();
        int moveNums = inputView.inputMoveView();

        ResultView.lineChange();
        ResultView.resultPrintResultComment();

        RACING_CAR.race(carNums, moveNums);
    }
}
