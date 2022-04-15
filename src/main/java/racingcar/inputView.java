package racingcar;

import java.util.Scanner;

public class inputView {

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int numOfCar = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numOfRound = scanner.nextInt();

        RacingCarGame game = new RacingCarGame(RacingCar.createBatch(numOfCar), numOfRound, new RandomNumCondition());
        game.start();

        scanner.close();
    }
}
