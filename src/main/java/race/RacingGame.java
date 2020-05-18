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

    public void startRacing() {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < time; i++) {
            start();
            OutputView.printRacingCars(racingCars);
        }
    }

    private void start() {
         racingCars.forEach(racingCar -> {
            if (movingStrategy.isMovable()) {
                racingCar.forward();
            }
        });
    }
}