package step2;

import java.util.List;
import java.util.Scanner;

public class RacingMain {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("시도할 회수는 몇 회 인가요?");
        int gameNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("레이싱 결과 출력 입니다.");
        RacingOutput racingOutput = new RacingOutput();
        RacingGame racingGame = new RacingGame();
        racingGame.carPositionsInit(carNumber);
        while (gameNumber > 0) {
            List<Integer> carPositions = racingGame.move();
            racingOutput.racingResult(carPositions);
            gameNumber--;
        }
    }

}
