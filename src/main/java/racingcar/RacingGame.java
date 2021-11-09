package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private String carNames;
    private int round;
    private List<Car> cars;

    public RacingGame(String carNames, int round) {
        this.carNames = carNames;
        this.round = round;
        this.cars = new ArrayList<>();
    }

    public void start() {
        generateCar();
        play();
    }

    public List<Car> winners() {
        final Integer longestStep = this.cars.stream().map(car -> car.info().step()).max((o1, o2) -> o1 - o2).get();
        return this.cars.stream().filter(car -> car.info().step() == longestStep).collect(Collectors.toList());
    }

    private void generateCar() {
        for (String name : carNames.split(",")) {
            this.cars.add(
                    new Car(
                            new Info(name, new Makable()),
                            new Movable()
                    )
            );
        }
    }

    private void play() {
        for (int i = 0; i < round; i++) {
            eachRound();
        }
    }

    private void eachRound() {
        for (Car car : cars) {
            car.move(fuel());
        }
    }

    private int fuel() {
        return new Random().nextInt(10);
    }
}
