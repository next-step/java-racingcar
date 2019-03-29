package car.domain;

import spark.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public List<Car> racingCars;
    private int racingCount;
    private int currentRound;

    private final static String UNDEFINED_CAR_NAME = "undefined";

    public RacingGame(String[] carsName, int racingCount) {
        this.racingCars = createRacingCars(carsName);
        this.racingCount = racingCount;
        this.currentRound = 0;
    }

    private List<Car> createRacingCars(String[] carsName) {
        List<Car> cars = new ArrayList<>();

        for ( String carName : carsName ) {
            String name = StringUtils.isBlank(carName) ? UNDEFINED_CAR_NAME : carName;
            cars.add(Car.getCarInstance(name));
        }
        return cars;
    }

    public GameResult playingGame() {
        move();
        currentRound ++;

        return GameResult.createResultInstance(racingCars);
    }

    private void move() {
        racingCars.stream().forEach(car -> {
            car.move(RandomNumber.getNumber());
        });
    }

    public boolean isRunning() {
        return currentRound < racingCount;
    }
}
