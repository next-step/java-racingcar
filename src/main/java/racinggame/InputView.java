package racinggame;

import java.util.Scanner;

public class InputView {

    public RacingGame intput() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCnt = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCnt = scanner.nextInt();
        return new RacingGame(carCnt, tryCnt);

    }
}
