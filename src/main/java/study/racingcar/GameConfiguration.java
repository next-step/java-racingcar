package study.racingcar;

import study.racingcar.car.Car;
import study.racingcar.car.Engine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 게임의 설정 값을 가지고 RacingCar를 초기화하는 책임 
 */
public class GameConfiguration {

    private int numberOfCars;
    private int numberOfAttempts;
    private Engine engine;

    public GameConfiguration(int numberOfCars, int numberOfAttempts, Engine engine) {
        this.numberOfCars = numberOfCars;
        this.numberOfAttempts = numberOfAttempts;
        this.engine = engine;

        validate();
    }

    private void validate (){
        if (numberOfCars < 1) {
            throw new IllegalArgumentException("자동차는 1대 이상이어야합니다.");
        }

        if (numberOfAttempts < 1) {
            throw new IllegalArgumentException("최소한 1번 이상의 시도를 해야합니다.");
        }
    }

    public RacingCars initRacingCars() {
        List<Car> cars = IntStream.range(0, numberOfCars)
                .mapToObj(i -> new Car())
                .collect(Collectors.toList());
        return new RacingCars(cars, engine);
    }

    public boolean doMoreAttempt(int currentAttempt) {
        return currentAttempt < numberOfAttempts;
    }
}

