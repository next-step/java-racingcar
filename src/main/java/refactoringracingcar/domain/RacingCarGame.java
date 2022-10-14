package refactoringracingcar.domain;

import refactoringracingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private int gameNumber;
    private List<Car> cars;

    public RacingCarGame(List<Car> cars, int gameNumber) {
        this.cars = cars;
        this.gameNumber = gameNumber;
    }

    public void RunGame() {
        for (int i = 0; i < gameNumber; i++) {
            RaceCarGame();
        }
    }

    private List<Car> RaceCarGame() {
        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            int moveDistance = new MovingStrategy().moveCarUnit();
            distances.add(moveDistance);
        }
        return new CarInformation().updateCarStatus(distances, cars);
    }


}
