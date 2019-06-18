package RacingGame;

public class MainController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputNames = inputView.inputNames();
        int inputTime = inputView.countTime();

        Racing racing = new Racing(inputTime, Util.stringSplitToList(inputNames, ","));
        racing.raceStart();

        OutputView outputView = new OutputView();
        outputView.printWinners(Util.joinListString(racing.getWinnerNames(), ", "));
    }
}
