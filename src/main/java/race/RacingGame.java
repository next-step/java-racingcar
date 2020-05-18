package race;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private int time;
    private List<RacingCar> racingCars;
    private final MovingStrategy movingStrategy;

    private RacingGame(int time, MovingStrategy movingStrategy) {
        this.time = time;
        this.movingStrategy = movingStrategy;
    }

    public static RacingGame create(int time, MovingStrategy movingStrategy) {
        return new RacingGame(time, movingStrategy);
    }

    public void readyRacingCars(int countOfCar) {
        this.racingCars = Stream.generate(RacingCar::ready)
            .limit(countOfCar)
            .collect(Collectors.toList());
    }

    public List<RacingCar> startRacing() {
        List<RacingCar> newRacingCars = start();

        return newRacingCars;
    }

    private List<RacingCar> start() {
         racingCars.forEach(racingCar -> {
            if (movingStrategy.isMovable()) {
                racingCar.forward();
            }
        });

        return racingCars;
    }
}