package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static List<Car> cars;
    private int currentTurn;
    private int moveCount;


    public RacingGame(String carNames, int moveCount) {
        this.cars = setupCar(carNames);
        this.moveCount = moveCount;

    }

    private List<Car> setupCar(String carNames) {
        cars = new ArrayList<>();
        String[] names = carNames.split(",");
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    public RacingResult startRace() {
        for (Car car : cars) {
            car.move();
        }
        currentTurn++;
        return new RacingResult(cars);
    }


    public List<Car> getCars() {
        return cars;
    }

    public boolean isEnd() {
        return currentTurn<= moveCount;
    }

}


