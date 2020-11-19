package racing.ui;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.RacingRound;
import racing.domain.RacingWinner;

public class ResultView {

    private static final String FORWARD_MARK = "-";

    private static void printReady() {
        System.out.println("실행결과");
        System.out.println();
    }

    public static void output(RacingRound racingRound, RacingWinner racingWinner) {
        printReady();
        printStart(racingRound);
        System.out.println("우승자는 :  " + racingWinner.getWinners());
    }

    private static void printStart(RacingRound racingRound) {
        int roundSize = racingRound.size();

        for (int round = 0; round < roundSize; round++) {
            printManager(racingRound, round);
        }
    }

    private static void printManager(RacingRound racingRound, int round) {
        Cars cars = racingRound.getCars(round);
        int carsSize = cars.size();

        for (int i = 0; i < carsSize; i++) {
            print(cars.getCar(i));
        }

        printAttemptDividingLine();
    }

    private static void print(Car car) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(FORWARD_MARK);
        }

        System.out.println(car.getName() + " : " + sb.toString());
    }

    private static void printAttemptDividingLine() {
        System.out.println("========================");
    }
}
