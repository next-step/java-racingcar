/*
 * RacingCarApplication.java *
 * v_0.1 *
 * 2021/7/26 *
 *
 * [저작권 및 라이센스 관련 정보를 여기 작성]
 * Copyright (c) 2021 Younhwan Son.
 */

package edu.nextstep.racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarApplication {

    public static void main(String[] args) {
        int carNum = InputView.inputCarNum();
        int moveNum = InputView.inputMoveNum();

        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            racingCarList.add(new RacingCar());
        }

        ResultView.startSign();
        for (int i = 0; i < moveNum; i++) {
            for(int j = 0; j < carNum; j++){
                racingCarList.get(i).move();
            }
            ResultView.outputCurrentRacing();
        }

    }
}
