package racingCar;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {

    /**
     * 경주 시작
     */
    public void start() {
        // 주관사 초기화
        RacingHost rh = new RacingHost();
        rh.inputCarNameAndTryNumber();
        System.out.println("");
        System.out.println("실행 결과");
        for (int i = 0; i < rh.inputTryNumber; i++) {
            rh.racing(rh.garage);
        }
        rh.chooseWinner(rh.garage);
    }
}
