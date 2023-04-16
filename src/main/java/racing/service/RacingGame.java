package racing.service;

import racing.domain.Car;
import racing.domain.Cars;
import racing.dto.GameResult;
import racing.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Cars cars;
    private final int turns;

    public RacingGame(int countOfCar, int turn) {

        this.turns = turn;

        List<Car> list = new ArrayList<>();
        for (int i = 0; i < countOfCar; i++) {
            list.add(new Car(0));
        }
        this.cars = new Cars(list);
    }

    public List<GameResult> playGame() {

        List<GameResult> results = new ArrayList<>();
        for (int i = 0; i < turns; i++) {
            results.add(this.cars.playOnceTurn());
        }

        return results;
    }
}
