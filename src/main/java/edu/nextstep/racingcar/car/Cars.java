package edu.nextstep.racingcar.car;

import edu.nextstep.racingcar.strategy.RacingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<RacingCar> cars;

    public Cars(List<RacingCar> racingCarList) {
        this.cars = racingCarList;
    }

    public static Cars createCarList(int carNum) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            racingCarList.add(new RacingCar());
        }
        return new Cars(racingCarList);
    }

    public void playRacingOneRound(RacingStrategy racingStrategy) {
        for (RacingCar car : cars) {
            car.move(racingStrategy);
        }
    }

    public RacingCar getCar(int index) {
        return cars.get(index);
    }

    public int size(){
        return cars.size();
    }
}
