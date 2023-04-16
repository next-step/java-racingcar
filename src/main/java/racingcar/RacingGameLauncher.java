package racingcar;

public class RacingGameLauncher {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int numberOfCars = inputView.promptNumberOfCars();
        int numberOfRounds = inputView.promptNumberOfRounds();

        System.out.println("입력한 자동차수 : " + numberOfCars + ", 입력한 라운드수 : " + numberOfRounds);

        Car[] cars = CarFactory.createCars(numberOfCars);
        RacingGame racingGame = new RacingGame(cars);

        for (int i = 0; i < numberOfRounds; i++) {
            racingGame.runSingleRound();
            resultView.showCarsDistance(cars);
        }
    }

}
