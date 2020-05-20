package com.kimdahyeee.racing;

import com.kimdahyeee.racing.view.InputView;
import com.kimdahyeee.racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int tryCount;
    private List<Car> racingCars;

    public RacingGame() {
        int carCount = InputView.getCarCount();
        setRacingCars(carCount);
        tryCount = InputView.getTryCount();
    }

    private void setRacingCars(int carCount) {
        racingCars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            racingCars.add(new Car());
        }
    }

    public void move() {
        ResultView.printHeader();

        for (int i = 0; i < tryCount; i++) {
            moveCar();
            ResultView.print(racingCars);
        }
    }

    protected void moveCar() {
        for (Car car : racingCars) {
            car.move();
        }
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.move();
    }
}
