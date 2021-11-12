package com.sryoondev.racingcar.step3;

import com.sryoondev.racingcar.step3.view.ResultView;

import java.util.ArrayList;

public class MyRacing {
    private MovableChecker movableChecker;
    private ArrayList<MyCar> myCars;

    public MyRacing(int carCount) {
        this.movableChecker = new MovableChecker();
        this.myCars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            myCars.add(new MyCar());
        }
    }

    public int getCarCount() {
        return myCars.size();
    }

    public void race() {
        for(MyCar car : myCars) {
            car.race(movableChecker.isMovable());
            ResultView.draw(car);
        }
    }
}