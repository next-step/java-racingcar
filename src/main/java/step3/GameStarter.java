package step3;

import java.util.Scanner;

public class GameStarter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCnt = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int gameCnt = scanner.nextInt();

        RacingGame racingGame = new RacingGame();
        racingGame.play(carCnt, gameCnt);
    }
}
