package RacingGame;

public class MainController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int inputTime = inputView.countTime();
        String inputNames = inputView.inputNames();

        Racing racing = new Racing(inputTime, inputNames);
        racing.raceStart();
    }
}
