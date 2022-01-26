package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomUtil;

public class RacingGame {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;

    private final List<RacingCar> racingCars;
    private int raceCount;

    public RacingGame(String carName, int raceCount) {
        racingCars = setRacingCars(carName);
        this.raceCount = raceCount;
    }

    public List<RacingCar> setRacingCars(String carName) {
        return Arrays.stream(carName.split(","))
            .map(RacingCar::new)
            .collect(Collectors.toList());
    }

    public void run() {
        while (0 < raceCount) {
            moveCars();
            printRacing();
            raceCount--;
            System.out.println("------------------------------");
        }
        printWinner();
    }

    public void moveCars() {
        for (RacingCar car : racingCars) {
            int value = RandomUtil.pickNumberInRange(RANDOM_START, RANDOM_END);
            car.move(value);
        }
    }

    public void printRacing() {
        racingCars.forEach(System.out::println);
    }

    public void printWinner() {
        int maxPosition = maxPosition();
        List<String> winners = getWinners(maxPosition);
        System.out.print("최종 우승자: " + String.join(", ", winners));
    }

    private int maxPosition() {
        return racingCars.stream()
            .mapToInt(RacingCar::getPosition)
            .max().getAsInt();
    }

    private List<String> getWinners(int maxPosition) {
        return racingCars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }
}

