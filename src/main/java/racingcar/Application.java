package racingcar;

import java.util.List;
import java.util.Scanner;

public class Application {
    private static final int MAX_RANGE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carCount = InputUtils.getIntegerValue(scanner, "자동차 대수는 몇 대 인가요? ");
        int tryCount = InputUtils.getIntegerValue(scanner, "시도할 회수는 몇 회 인가요? ");

        System.out.println();

        RacingGame racingGame = new RacingGame(carCount, new RandomGeneratorImpl(MAX_RANGE));
        List<Car> cars = racingGame.getCars();

        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                racingGame.run(car);
                System.out.println(racingGame.generateRaceResultString(car));
            }
            System.out.println();
        }
    }
}
