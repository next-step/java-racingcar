package racing;

import java.util.Scanner;

public class InputView {
    public static RacingGame getRacingGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCnt =  sc.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCnt = sc.nextInt();

        System.out.println("실행결과");
        return new RacingGame(carCnt, tryCnt);
    }
}
