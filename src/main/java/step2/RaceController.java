package step2;

public class RaceController {

    public static void main(String[] args) {
        String nameOfCars = InputView.getNameOfCars();
        int tryCount = InputView.getTryCount();

        RacingGame racingGame = new RacingGame(nameOfCars);

        ResultView.printStartMessage(racingGame.getCarNames());

        for (int i = 0; i < tryCount; i++) {
            ResultView.print(racingGame.move());
        }
    }
}
