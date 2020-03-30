package racingGame.domain;

import racingGame.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> allCars;
    private final int BOUND = 10;
    private final int MOVE_CONDITION = 4;

    public RacingGame(String[] carNames) {
        this.allCars = new ArrayList<>(carNames.length);

        for (int idx = 0; idx < carNames.length; idx++) {
            Car racingCar = new Car(carNames[idx]);
            allCars.add(racingCar);
        }
    }

    public List<Car> racing() {
        return allCars.stream()
                .map(i -> moveNowCar(i))
                .collect(Collectors.toList());
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

    public Boolean moveOrNot(int randomNum) {
        return randomNum >= MOVE_CONDITION;
    }

    public List<String> findWinners() {
        return new Winner(allCars).findWinnerNames();
    }
}
