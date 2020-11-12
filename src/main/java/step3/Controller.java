package step3;

import step3.domain.Racing;
import step3.domain.Randomize;
import step3.domain.strategy.Movable;
import step3.domain.strategy.MoveStrategy;
import step3.view.InputView;
import step3.view.ResultView;

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
        MoveStrategy moveStrategy = new Movable(new Randomize());

        Racing racing = Racing.of(carNames, roundNum, moveStrategy);
        racing.race();

        ResultView.printResult(racing.getScoreBoard(), racing.getRounds());
        ResultView.printWinner(racing.getWinner());

        SCANNER.close();
    }

}
