/*
 *   Class name : RacingCarPlayMain.java
 *   Version : 0.0.1
 *   Date : 2021/07/24
 */

package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 해당 메소드의 기능은 자동차 경주 게임을 시작합니다.
 * 자동차의 수와 , 이동하는 횟수를 입력받습니다.
 */
public class RacingCarPlayMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        RacingCarResultView view  = new RacingCarResultView();
        String[] carNames = view.getCarNames(br);
        int moveCount = view.getMoveCount(br);
        int range = 10;

        RacingCar racingCar = new RacingCar(carNames ,moveCount, range);
        view.drawRacingResult();
        racingCar.start();

    }
}
