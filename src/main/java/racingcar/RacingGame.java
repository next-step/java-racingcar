/*
 * 자동차 경주을 실행하는 메인 클래스
 *
 * @author hj-woo
 * @version 2.0
 * */

package racingcar;

import racingcar.domain.Game;
import racingcar.ui.InputView;

import java.util.List;

import static racingcar.GameFactory.STEP4_STR;

public class RacingGame {
    public static void main(String[] args) {
//        Game step3Game = GameFactory.step3Game();

        List<Object> inputArr = InputView.input(STEP4_STR);
        InputView.closeScanner();
        Game step4Game = GameFactory.step4Game(inputArr);
        step4Game.play();

    }
}
