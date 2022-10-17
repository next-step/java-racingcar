package refactoringracingcar.domain;

import java.util.List;

public class RacingCarGame {

    private int gameNumber;
    public static List<Car> cars;
    private CarInformation carInformation = new CarInformation();

    public RacingCarGame(List<Car> cars, int gameNumber) {
        this.cars = cars;
        this.gameNumber = gameNumber;
    }

    public void raceCarGame() {
        for (int i = 0; i < cars.size(); i++) {
            int moveDistance = new MovingStrategy().moveCarUnit();
            carInformation.updateCarStatus(i, moveDistance);
        }
    }

}
