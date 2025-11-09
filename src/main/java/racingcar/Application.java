package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int carCount;
        int roundCount;

        try (Scanner sc = new Scanner(System.in)) {
            carCount = readCarCount(sc);
            roundCount = readRoundCount(sc);
        }

        RaceHistory history = executeGame(carCount, roundCount);

        printResult(history);
    }

    private static int readCarCount(Scanner sc) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return sc.nextInt();
    }

    private static int readRoundCount(Scanner sc) {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return sc.nextInt();
    }

    private static RaceHistory executeGame(int carCount, int roundCount) {
        Cars cars = new Cars(carCount);
        SimpleRandomNumber randomNumber = new SimpleRandomNumber();
        RacingGame game = new RacingGame(cars, randomNumber);

        return game.race(roundCount);
    }

    private static void printResult(RaceHistory history) {
        System.out.println("실행 결과");

        for (RoundResult roundResult : history.getRounds()) {
            for (int position : roundResult.positions()) {
                System.out.println("-".repeat(Math.max(0, position)));
            }
            System.out.println();
        }
    }
}
