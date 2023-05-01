package study;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingService {

    public static final String HYPHEN = "-";

    public List<RacingCar> createRacingCars(int quantity) {

        List<RacingCar> racingCars = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            RacingCar racingCar = new RacingCar();
            racingCars.add(racingCar);
        }

        return racingCars;
    }

    public void moveForwardWhenFourHigher(RacingCar racingCar) {
        if (getRandomNumberZeroToNine() >= 4) {
            racingCar.moveForward();
        }
    }

    public int getRandomNumberZeroToNine() {
        return (int) (Math.random() * 10);
    }

    public void printStatus(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(HYPHEN.repeat(racingCar.position()));
        }
    }

    public void startRacingGame(int tryCount, List<RacingCar> racingCars) {
        printStatus(racingCars);
        System.out.println(); // 개행

        IntStream.range(0, tryCount).forEach(i -> {
            racingCars.forEach(this::moveForwardWhenFourHigher);

            printStatus(racingCars);
            System.out.println(); // 개행
        });
    }

}
