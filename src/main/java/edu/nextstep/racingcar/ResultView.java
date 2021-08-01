/*
 * ResultView.java *
 * v_0.1 *
 * 2021/7/26 *
 *
 * [저작권 및 라이센스 관련 정보를 여기 작성]
 * Copyright (c) 2021 Younhwan Son.
 */

package edu.nextstep.racingcar;

import java.util.List;

public class ResultView {
    public static void startSign() {
        System.out.println("\n실행 결과");
    }

    public static void outputCurrentRacing(Cars racingCars) {
        for (int i = 0; i < racingCars.size(); i++) {
            for(int j = 0; j < racingCars.getCar(i).getMovedDistance(); j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
