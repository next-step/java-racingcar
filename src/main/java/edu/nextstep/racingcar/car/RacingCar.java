/*
 * Car.java *
 * v_0.1 *
 * 2021/7/26 *
 *
 * [저작권 및 라이센스 관련 정보를 여기 작성]
 * Copyright (c) 2021 Younhwan Son.
 */

package edu.nextstep.racingcar.car;

import edu.nextstep.racingcar.strategy.RacingStrategy;

public class RacingCar {

    private int movedDistance = 0;

    public void move(RacingStrategy racingStrategy) {
        if (racingStrategy.canMove()) {
            this.movedDistance++;
        }
    }

    public int getMovedDistance() {
        return movedDistance;
    }


}
