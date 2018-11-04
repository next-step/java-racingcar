package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

    private int tryTime;
    private List<RacingCar> racingCars;

    private static final int RANDOM_NUMBER_BOUNDARY = 10;
    private static final int START_POSITION = 0;

    public Racing(String cars, int tryTime) {
        this.racingCars = generateRacingCars(cars);
        this.tryTime = tryTime;
    }

    private List<RacingCar> generateRacingCars(String cars) {
        String [] carNames = cars.split(",");

        this.racingCars = Arrays.stream(carNames)
                .map(carName -> new RacingCar(START_POSITION, carName))
                .collect(Collectors.toList());

        return this.racingCars;
    }

    public void startRace() {
        IntStream.range(0, this.tryTime)
                .forEach(i -> {
                    moveCars();
                    ResultView.printCars(getRacingCars());
                    System.out.println();
                });

       ResultView.printWinners(winner());
    }

    public void moveCars() {
        this.racingCars
                .forEach(racingCar -> racingCar.move(generateRandomNum()));
    }

    public String winner() {
        int maxPosition = findMaxPosition(
                racingCars.stream()
                            .map(racingCar -> racingCar.getPosition())
                            .collect(Collectors.toList()));

        return this.racingCars.stream()
                .filter(r -> r.isSamePosition(maxPosition))
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
    }


    protected int findMaxPosition(List<Integer> positions) {

        int maxPosition = positions.stream()
                .mapToInt(value -> value)
                .max()
                .orElse(0);

        return maxPosition;
    }

    public static int generateRandomNum() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUNDARY);
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }


    public static void main(String[] args) {
        String cars = InputView.inputCars();
        int tryTime = InputView.inputTryTime();

        Racing r = new Racing(cars, tryTime);
        r.startRace();
    }
}