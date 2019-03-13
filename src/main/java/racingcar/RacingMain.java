package racingcar;

import java.util.Scanner;

public class RacingMain {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        System.out.println("자동차 대수는 몇대인가요?");
        Scanner scanner = new Scanner(System.in);
        racingGame.setRacingCarCnt(scanner.nextInt());
        System.out.println("시도할 회수는 몇 회 인가요?");
        racingGame.setTryCnt(scanner.nextInt());
        System.out.println("실행 결과");
        racingGame.executionResult();
    }
}
