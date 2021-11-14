package racingCar.model;

import racingCar.model.Car;
import racingCar.view.ResultView;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCarGame {
    private int tryTimes;
    private List<Car> raceCar = new ArrayList<>();
    private ResultView resultView = new ResultView();

    public RacingCarGame(String[] carNames, int tryTimes) {
        if (tryTimes < 0) {
            throw new IllegalArgumentException("올바른 수를 입력하세요.");
        }
        setRaceCar(carNames);
        this.tryTimes = tryTimes;
    }

    private void setRaceCar(String[] carNames) {
        for (String name : carNames) {
            raceCar.add(new Car(name));
        }
    }

    public List<Car> getRaceCar() {
        return this.raceCar;
    }

    public List<Car> winnersCars() {
        return raceCar.stream()
                .filter(car -> car.getMoveCount() == maxMoveCar().getMoveCount())
                .collect(Collectors.toList());
    }

    public Car maxMoveCar() {
        return raceCar.stream()
                .max(Comparator.comparingInt(Car::getMoveCount))
                .orElseThrow(NoSuchElementException::new);
    }

}
