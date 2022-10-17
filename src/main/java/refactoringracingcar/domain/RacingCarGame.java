package refactoringracingcar.domain;

import refactoringracingcar.view.ResultView;

import java.util.List;

public class RacingCarGame {

    private int gameNumber;
    public static List<Car> cars;
    private CarInformation carInformation = new CarInformation();

    public RacingCarGame(List<Car> cars, int gameNumber) {
        this.cars = cars;
        this.gameNumber = gameNumber;
    }

    public String runGame() {
        String gameResult = "";
        ResultView resultView = new ResultView(cars);
        for (int i = 0; i < gameNumber; i++) {
            raceCarGame();
            gameResult += resultView.printGameStatus();
        }
        gameResult += resultView.printWinner();
        return gameResult;
    }

    private void raceCarGame() {
        for (int i = 0; i < cars.size(); i++) {
            int moveDistance = new MovingStrategy().moveCarUnit();
            carInformation.updateCarStatus(i, moveDistance);
        }
    }

}
