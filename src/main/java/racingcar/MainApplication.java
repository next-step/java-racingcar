package racingcar;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RacingGame racingGame = new RacingGame();

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = scanner.nextInt();
        racingGame.setCarNumber(carNumber);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();
        racingGame.setTime(time);

        System.out.println("실행 결과");
        racingGame.gameStart();

    }
}
