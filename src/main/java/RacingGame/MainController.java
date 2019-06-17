package RacingGame;

public class MainController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int inputTime = inputView.countTime();
        int inputCountCar = inputView.countCar();

        Racing racing = new Racing();
        racing.setTime(inputTime);
        racing.setCars(racing.arrayWithCar(inputCountCar));
        racing.raceStart();

        OutputView outputView = new OutputView();
        outputView.printRace(racing.getCars());
    }
}
