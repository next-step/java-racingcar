package racinggame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int currentRound = 0;
    private List<Car> carList;
    private RacingGameParameters racingGameParameters;

    public RacingGame(RacingGameParameters racingGameParameters) {
        this.racingGameParameters = racingGameParameters;
        this.carList = createCars(racingGameParameters.getCarQuantity());
    }

    private List<Car> createCars(int carQuantity) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carQuantity; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    void playRound() {
        this.currentRound += 1;
        for (Car car : this.carList) {
            car.move();
        }
    }
}
