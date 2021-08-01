package com.racingcar.game;

import com.racingcar.car.Car;

import java.util.List;

public interface MakeCarsRule <T> {
    List<Car> makeCar(T input);
}
