package RacingGame;

public class MainController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String inputNames = inputView.inputNames();
        int inputTime = inputView.countTime();

        Racing racing = new Racing(inputTime, inputNames);
        racing.raceStart();
    }
}
