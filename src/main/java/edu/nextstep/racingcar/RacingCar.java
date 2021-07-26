/*
 * Car.java *
 * v_0.1 *
 * 2021/7/26 *
 *
 * [저작권 및 라이센스 관련 정보를 여기 작성]
 * Copyright (c) 2021 Younhwan Son.
 */

package edu.nextstep.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    private int movedDistance = 0;

    public void move() {
        int n = getRandomNum();
        if (n >= 4) {
            moveRacingCar();
        }
    }

    private int getRandomNum() {
        Random randomUtil = new Random();
        return randomUtil.nextInt(10);
    }

    private void moveRacingCar() {
        this.movedDistance++;
    }

    public int getMovedDistance() {
        return movedDistance;
    }

    public static List<RacingCar> createCarList(int carNum) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            racingCarList.add(new RacingCar());
        }
        return racingCarList;
    }
}
