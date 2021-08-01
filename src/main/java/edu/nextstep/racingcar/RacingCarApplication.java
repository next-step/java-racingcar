/*
 * RacingCarApplication.java *
 * v_0.1 *
 * 2021/7/26 *
 *
 * [저작권 및 라이센스 관련 정보를 여기 작성]
 * Copyright (c) 2021 Younhwan Son.
 */

package edu.nextstep.racingcar;

public class RacingCarApplication {

    public static void main(String[] args) {
        int carNum = InputView.inputCarNum();
        int moveNum = InputView.inputMoveNum();

        Cars racingCars = RacingCar.createCarList(carNum);

        ResultView.startSign();
        for (int i = 0; i < moveNum; i++) {
            racingCars.playRacingOneRound();
            ResultView.outputCurrentRacing(racingCars);
        }

    }
}
