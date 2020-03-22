package racinggame;

import racinggame.expression.InputView;
import racinggame.expression.ResultView;

import java.util.Scanner;

/**
 * racing game 메인
 */
public class RacingGameApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        String carCount = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        String gameCount = scanner.nextLine();

        System.out.println("실행 결과");
//        InputView inputView = new InputView(carCount, gameCount);
//        ResultView.racingGameStart(inputView.getGameCount(), inputView.getCars());

        System.out.println(carCount + "  " + gameCount);
    }
}
