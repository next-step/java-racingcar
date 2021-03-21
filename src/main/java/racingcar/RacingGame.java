/*
 * 자동차 경주을 실행하는 메인 클래스
 *
 * @author hj-woo
 * @version 2.0
 * */

package racingcar;

import racingcar.domain.Game;
import racingcar.domain.Name;
import racingcar.domain.Position;
import racingcar.domain.Rule;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static racingcar.GameFactory.STEP4_STR;

public class RacingGame {
    public static void main(String[] args) {
        Game step4Game = createGame(STEP4_STR);
        ArrayList<Map<Name, Position>> results = step4Game.play();
        ResultView.printAllResultWithName(results);
        ResultView.printWinner(Rule.whoIsWinner(results.get(results.size() - 1)));

    }

    public static Game createGame(String[] step) {
        Game game;
        try {
            List<Object> inputArr = InputView.input(step);
            game = GameFactory.game(step, inputArr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            game = createGame(step);
        }
        InputView.closeScanner();

        return game;
    }
}
