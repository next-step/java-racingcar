package step4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final String DELIMITER = ",";
    private static final int IDENTITY = 0;

    private List<RacingCar> racingCars;
    private final MovingStrategy movingStrategy;

    private RacingGame(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public static RacingGame create(MovingStrategy movingStrategy) {
        return new RacingGame(movingStrategy);
    }

    public void readyRacingCars(String carName) {
        String[] carNames = carName.trim().split(DELIMITER);
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

    public String getWinners() {
        return this.racingCars.stream()
            .filter(car -> car.currentPosition() == getMaxPosition(racingCars))
            .map(RacingCar::getName)
            .collect(Collectors.joining(DELIMITER));
    }

    private int getMaxPosition(List<RacingCar> racingCars) {
        return racingCars.stream()
            .map(RacingCar::currentPosition)
            .reduce(IDENTITY, Math::max);
    }
}