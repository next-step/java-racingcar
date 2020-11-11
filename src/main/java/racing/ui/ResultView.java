package racing.ui;

import racing.Car;
import racing.Cars;
import racing.RandomGenerator;

public class ResultView {

    private static final String FORWARD_MARK = "-";

    public static void output(int numberOfAttempt, Cars cars) {
        ready();
        start(numberOfAttempt, cars);
    }

    private static void ready() {
        System.out.println();
        System.out.println("실행결과");
    }

    private static void start(int numberOfAttempt, Cars cars) {
        for (int i = 0; i < numberOfAttempt; i++) {
            race(cars);
            printAttemptDividingLine();
        }
    }

    private static void race(Cars cars) {
        for (int i = 0; i < cars.size(); i++) {
            raceResult(cars.getCar(i));
        }
    }

    private static void raceResult(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        int randomNumber = RandomGenerator.getRandomRange();

        car.move(randomNumber);

        for (int i = 0; i < car.getTravelDistance(); i++) {
            stringBuilder.append(FORWARD_MARK);
        }

        System.out.println(stringBuilder.toString());
    }

    private static void printAttemptDividingLine() {
        System.out.println("========================");
    }
}
