package step5;

import step5.domain.Racing;
import step5.domain.Randomize;
import step5.domain.strategy.Movable;
import step5.domain.strategy.MoveStrategy;
import step5.view.InputView;
import step5.view.ResultView;

import java.util.Scanner;

/**
 * Created By mand2 on 2020-11-04.
 * 실제 게임 보여주는 판.
 */
public class Controller {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String carNames = InputView.askCarNames();
        int roundNum = InputView.askRoundNumber();

        Racing racing = Racing.of(carNames, roundNum, new Movable());
        racing.race();

        ResultView.printResult(racing.getScoreBoard(), racing.getRounds());
        ResultView.printWinner(racing.getWinner());

        SCANNER.close();
    }

}
