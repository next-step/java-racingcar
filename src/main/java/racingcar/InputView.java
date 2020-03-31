package racingcar;

import java.util.Scanner;

public class InputView {

    public static RacingGame start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfTry = scanner.nextInt();

        RacingGame racingGame = new RacingGame(numberOfTry, carNames);
        return racingGame;
    }
}
