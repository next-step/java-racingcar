package racingcar.step3;

import java.util.Scanner;

public class AppClient {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int totalCar = sc.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int finalRound = sc.nextInt();
        System.out.println("실행 결과");

        RacingGame racingGame = new RacingGame(finalRound, totalCar);
        while (!racingGame.isEndGame()) {
            System.out.println(racingGame);
            racingGame.moveCars();
            racingGame.roundUp();
        }
    }

}
