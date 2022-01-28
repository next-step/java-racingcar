package racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private static final int RANGE_OF_RANDOM_NUMBER = 10;

    private final List<Car> cars;

    public RacingGame() {
        this.cars = new ArrayList<>();
    }

    public void startGame() {
        try {
            final List<String> names = UserInput.getCarNames();
            for (String name : names) {
                cars.add(new Car(name));
            }
            checkCarCount(cars);

            final TryNumber tryNumber = UserInput.getTryNumber();
            startRacing(tryNumber);
            showGameResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            startGame();
        }
    }

    private static void checkCarCount(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 최소 1대 이상의 자동차가 필요합니다.");
        }
    }

    private void startRacing(final TryNumber tryNumber) {
        System.out.println("\n실행 결과");
        while (tryNumber.isPossibleToRace()) {
            driveCars();
            System.out.println();
        }
    }

    private void driveCars() {
        for (Car car : cars) {
            car.drive(generateRandomNumber());
        }
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * RANGE_OF_RANDOM_NUMBER);
    }

    private void showGameResult() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        final List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            winners.add(car.getNameBy(maxPosition));
        }
        winners.removeAll(Arrays.asList("", null));

        final String resultOfWinners = String.join(", ", winners);
        System.out.println("최종 우승자 : " + resultOfWinners);
    }
}
