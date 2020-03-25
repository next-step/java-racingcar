package racinggame;

import racinggame.domain.racing.Racing;
import racinggame.domain.view.InputView;
import racinggame.domain.view.ResultView;

import java.util.Scanner;

/**
 * racing game 메인
 */
public class RacingGameApplication {
    private static final String INPUT_REQUEST_CAR_NAMES_ANNOUNCE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_REQUEST_ROUND_ANNOUNCE = "시도할 회수는 몇 회 인가요?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_REQUEST_CAR_NAMES_ANNOUNCE);
        String carNames = scanner.nextLine();
        System.out.println(INPUT_REQUEST_ROUND_ANNOUNCE);
        String gameCount = scanner.nextLine();

        InputView inputView = new InputView(gameCount, carNames);

        Racing racing = new Racing(inputView.getGameCount(), inputView.getCarNames());
        racing.playAllRound();

        ResultView resultView = new ResultView();
        resultView.drawAllRoundResult(racing.getRoundResult());
        resultView.drawWinners(racing);
    }
}
