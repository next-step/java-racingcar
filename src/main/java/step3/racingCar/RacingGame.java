/*
 * 자동차 경주을 실행하는 메인 클래스
 *
 * @author hj-woo
 * @version 2.0
 * */

package step3.racingCar;

import step3.racingCar.ui.InputView;

public class RacingGame {
    public static void main(String[] args) {
//        Game step3Game = GameFactory.step3Game();
        Game step4Game = GameFactory.step4Game();
        step4Game.play();
        InputView.closeScanner();
    }
}
