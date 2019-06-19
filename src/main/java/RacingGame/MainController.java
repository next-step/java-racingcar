package RacingGame;

public class MainController {

    public static void main(String[] args) {
        String inputNames = InputView.inputNames();
        int inputTime = InputView.countTime();

        Racing racing = new Racing(inputTime, Util.stringSplitToList(inputNames, ","));
        racing.raceStart();

        OutputView.printWinners(Util.joinListString(racing.getWinnerNames(), ", "));
    }
}
