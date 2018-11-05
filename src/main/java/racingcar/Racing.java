package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Racing {

    private static final int RANDOM_NUMBER_BOUNDARY = 10;
    private static final int START_POSITION = 0;

    private List<RacingCar> racingCars;

    public Racing(String cars) {
        this.racingCars = generateRacingCars(cars);
    }

    private List<RacingCar> generateRacingCars(String cars) {
        String [] carNames = cars.split(",");

        this.racingCars = Arrays.stream(carNames)
                .map(carName -> new RacingCar(START_POSITION, carName))
                .collect(Collectors.toList());

        return this.racingCars;
    }

    public List<RacingCar> moveCars() {
        this.racingCars
                .forEach(racingCar -> racingCar.move(generateRandomNum()));

        return this.racingCars;
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

        Racing racing = new Racing(cars);
        GameResult result;

        for(int i = 0; i < tryTime; i++) {
            racing.moveCars();
            ResultView.printCars(racing.getRacingCars());
            System.out.println();

        }

        result = new GameResult(racing.getRacingCars());
        ResultView.printWinners(result);
    }
}