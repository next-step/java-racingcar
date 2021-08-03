/*
 * ResultView.java *
 * v_0.1 *
 * 2021/7/26 *
 *
 * [저작권 및 라이센스 관련 정보를 여기 작성]
 * Copyright (c) 2021 Younhwan Son.
 */

package edu.nextstep.racingcar.view;

import edu.nextstep.racingcar.car.Cars;

public class ResultView {
    public static void startSign() {
        System.out.println("\n실행 결과");
    }

    public static void outputCurrentRacing(Cars racingCars) {
        for (int i = 0; i < racingCars.size(); i++) {
            printDistance(racingCars.getCar(i).getMovedDistance());
        }
        System.out.println();
    }

    private static void printDistance(int distance) {
        for(int j = 0; j < distance; j++){
            System.out.print("-");
        }
        System.out.println();
    }
}
