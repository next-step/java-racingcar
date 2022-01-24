package racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private int maxPosition;

    public RacingGame() {
        this.cars = new ArrayList<>();
    }

    public void startGame() {
        try {
            final List<String> nameList = UserInput.getCarNames();
            for (String name : nameList) {
                cars.add(new Car(name));
            }

            final int tryNumber = UserInput.getTryNumber();
            startRacing(tryNumber);
            showGameResult();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            startGame();
        }
    }

    private void startRacing(final int tryNumber) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            driveCars();
            System.out.println();
        }
    }

    private void driveCars() {
        for (Car car : cars) {
            car.drive();
        }
    }

    private void showGameResult() {
        for (Car car : cars) {
            setMaxPosition(car.getPosition());
        }

        final List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            winners.add(car.checkSamePosition(maxPosition));
        }
        winners.removeAll(Arrays.asList("", null));

        final String resultOfWinners = String.join(", ", winners);
        System.out.println("최종 우승자 : " + resultOfWinners);
    }

    private void setMaxPosition(final int position) {
        if (position > maxPosition) {
            maxPosition = position;
        }
    }
}
