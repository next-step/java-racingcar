package racing;

import java.util.Scanner;

public class InputView {

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int number = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int count = scanner.nextInt();

        RacingGame racingGame = new RacingGame(number, count);
        racingGame.startRacing();
    }
}
