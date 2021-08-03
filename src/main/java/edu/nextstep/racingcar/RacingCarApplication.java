/*
 * RacingCarApplication.java *
 * v_0.1 *
 * 2021/7/26 *
 *
 * [저작권 및 라이센스 관련 정보를 여기 작성]
 * Copyright (c) 2021 Younhwan Son.
 */

package edu.nextstep.racingcar;

import edu.nextstep.racingcar.car.Cars;
import edu.nextstep.racingcar.strategy.RandomStrategy;
import edu.nextstep.racingcar.view.InputView;
import edu.nextstep.racingcar.view.ResultView;

public class RacingCarApplication {

    public static void main(String[] args) {
        int carNum = InputView.inputCarNum();
        int moveNum = InputView.inputMoveNum();

        Cars racingCars = Cars.createCarList(carNum);

        ResultView.startSign();
        for (int i = 0; i < moveNum; i++) {
            racingCars.playRacingOneRound(new RandomStrategy());
            ResultView.outputCurrentRacing(racingCars);
        }

    }
}
