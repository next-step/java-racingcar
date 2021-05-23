package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racing.view.Output.printNowDistance;

public class RacingGame {
    public static final String SEPARATOR = ",";

    List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.isMove();
        }
    }

    public List<Car> findWinner() {
        List<Car> winnerCars = new ArrayList<>();
        int winnerCondition = findWinnerCondition();
        for (Car car : this.cars) {
            if (car.isWinner(winnerCondition)) {
                winnerCars.add(car);
            }
        }
        return winnerCars;
    }

    private int findWinnerCondition() {
        int winnerCondition = 0;
        for (Car car : this.cars) {
            winnerCondition = Math.max(winnerCondition, car.getMoveCount());
        }
        return winnerCondition;
    }
    //츨력 수정하기
    public static void repeatMoveCars(List<Car> cars, int count) {
        for (int i = 0; i < count; i++) {
            RacingGame.moveCars(cars);
            printNowDistance(cars);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }
}