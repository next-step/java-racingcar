package edu.nextstep.racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<RacingCar> cars = new ArrayList<>();

    public Cars(List<RacingCar> racingCarList) {
        this.cars = racingCarList;
    }

    public void playRacingOneRound() {
        for (RacingCar car : cars) {
            car.move();
        }
    }

    public RacingCar getCar(int index) {
        return cars.get(index);
    }

    public int size(){
        return cars.size();
    }
}
