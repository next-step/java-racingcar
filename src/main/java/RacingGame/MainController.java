package RacingGame;

public class MainController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int inputTime = inputView.countTime();
        int inputCountCar = inputView.countCar();

        Racing racing = new Racing(inputTime, inputCountCar);
        racing.raceStart();

        OutputView outputView = new OutputView();
        outputView.printRace(racing.getCars());
    }
}
