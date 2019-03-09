package racingcar;

import java.util.Scanner;

public class RacingGameApplication {
    public static void main(String[] args) {
        RacingGameApplication.start();
    }

    public static void start() {
        RacingGameParameter parameter = readRacingGameParameter();
        RacingGame racingGame = new RacingGame(parameter.numberOfCar);
        racingGame.start(parameter.tryCount);
    }

    private static class RacingGameParameter {
        public RacingGameParameter(int numberOfCar, int tryCount) {
            this.numberOfCar = numberOfCar;
            this.tryCount = tryCount;
        }

        private int numberOfCar;
        private int tryCount;
    }

    private static RacingGameParameter readRacingGameParameter() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCar = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();
        System.out.println();

        scanner.close();

        return new RacingGameParameter(numberOfCar, tryCount);
    }

}
