package racingcar;

import java.util.Scanner;

public class InputView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        String carInput = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        String attemptInput = scanner.nextLine();
        System.out.println("실행 결과");

        RacingGame racingGame = new RacingGame();
        racingGame.start(carInput, attemptInput);

    }
}
