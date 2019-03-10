package racingcar;

import java.util.Scanner;

public class RacingGameRunner {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int cars = scan.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scan.nextInt();

        RacingGame racingGame = new RacingGame(cars, time);
        racingGame.move();
    }
}
