package study;

import java.util.Scanner;

public class ResultView {
    public static void main(String[] args) {

        startRacing();
    }


    public static void startRacing() {
        RacingGame racingGame = new RacingGame();
        Scanner scan = new Scanner(System.in);

        System.out.println("자동차의 대수는 몇 대 인가요?");
        int carQuantity = scan.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scan.nextInt();

        System.out.println("실행 결과");
        RacingCars racingCars = new RacingCars(carQuantity);

        racingGame.startRacingGame(tryCount, racingCars);
    }
}
