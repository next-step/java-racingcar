package carracing;

public class RacingDisplay {

    private static final RacingCar RACING_CAR = new RacingCar();

    public static void main(String[] args) {
        int carNums = InputView.inputCarView();
        int moveNums = InputView.inputMoveView();

        ResultView.lineChange();
        ResultView.resultPrintResultComment();

        RACING_CAR.race(carNums, moveNums);
    }
}
