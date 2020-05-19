package step4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<RacingCar> racingCars;
    private final MovingStrategy movingStrategy;
    private static final String DELIMITER = ",";

    private RacingGame(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public static RacingGame create(MovingStrategy movingStrategy) {
        return new RacingGame(movingStrategy);
    }

    public void readyRacingCars(String carName) {
        String[] carNames = carName.split(DELIMITER);
        this.racingCars = Arrays.stream(carNames)
            .map(RacingCar::ready)
            .collect(Collectors.toList());
    }

    public List<RacingCar> startRacing() {
        start();
        return racingCars.stream()
            .map(car -> new RacingCar(car.getName(), car.currentPosition()))
            .collect(Collectors.toList());
    }

    private List<RacingCar> start() {
        racingCars.forEach(this::forwardRacingCar);

        return racingCars;
    }

    private void forwardRacingCar(RacingCar racingCar) {
        if (movingStrategy.isMovable()) {
           racingCar.forward();
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}