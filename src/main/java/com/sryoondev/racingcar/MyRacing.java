package com.sryoondev.racingcar;

import java.util.ArrayList;

public class MyRacing {
    private final int racingCount;
    private MovableChecker movableChecker;
    private ArrayList<MyCar> myCars;

    public MyRacing(int carCount, int racingCount) {
        this.racingCount = racingCount;
        this.movableChecker = new MovableChecker();
        this.myCars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            myCars.add(new MyCar());
        }
    }

    public int getCarCount() {
        return myCars.size();
    }

    public int getRacingCount() {
        return this.racingCount;
    }

    public ArrayList<MyCar> race() {
        for(MyCar car : myCars) {
            car.race(movableChecker.isMovable());
        }
        return myCars;
    }

    public void start() {
        for (int i = 0; i < racingCount; i++) {
            race();
        }
    }
}
