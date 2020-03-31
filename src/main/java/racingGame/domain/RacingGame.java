package racingGame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private final int BOUND = 10;
    private final int MOVE_CONDITION = 4;
    private List<Car> allCars;

    public RacingGame(String[] carNames) {
        this.allCars = new ArrayList<Car>(carNames.length);
        for (String carName : carNames) {
            Car racingCar = new Car(carName);
            allCars.add(racingCar);
        }
    }

    public List<Car> racing() {
        for (Car car : allCars) {
            moveNowCar(car);
        }
        return allCars;
    }

    private Car moveNowCar(Car nowCar) {
        if (this.moveOrNot(this.getRandomNum())) {
            nowCar.moveCar();
        }
        return nowCar;
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }

    public boolean moveOrNot(int randomNum) {
        return randomNum >= MOVE_CONDITION;
    }

    public List<String> findWinners() {
        return new Winner(allCars).findWinnerNames();
    }
}
