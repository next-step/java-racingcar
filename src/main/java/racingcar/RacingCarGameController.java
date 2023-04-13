package racingcar;

public class RacingCarGameController {
    public static void main(String[] args) {
        String[] carNames = getCarNames();
        int numberOfTries = InputView.getNumberOfTries();

        RacingCarGame racingCarGame = RacingCarGame.setUpGame(carNames);

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfTries; i++) {
            racingCarGame.play();
            OutputView.printPosition(racingCarGame.getRacingCars());
        }

        OutputView.printWinners(racingCarGame.getWinners());
    }

    private static String[] getCarNames() {
        String carNamesString = InputView.getCarNames();
        String[] carNames = carNamesString.split(",");
        return carNames;
    }
}
