package refactoringracingcar.domain;

import java.util.List;

public class RacingCarGame {

    private List<Car> cars;
    private CarInformation carInformation = new CarInformation();

    public RacingCarGame(List<Car> cars) {
        this.cars = cars;
    }

    public void raceCarGame() {
        for (int i = 0; i < cars.size(); i++) {
            int moveDistance = new MovingStrategy().moveCarUnit();
            carInformation.updateCarStatus(i, moveDistance, cars);
        }
    }

}
