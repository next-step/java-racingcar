package com.racingcar.game;

import com.racingcar.car.Car;
import com.racingcar.view.model.GameInputDto;

import java.util.ArrayList;
import java.util.List;

public class GameMaker {
    public static Game make(GameInputDto input) {
        return new Game(input.getGameRound(), makeCars(input.getNames()));
    }

    private static List<Car> makeCars(String names) {
        List<Car> cars = new ArrayList<>();
        String[] nameArray = names.split(",");

        for (int i = 0; i < nameArray.length; i++) {
            cars.add(new Car(nameArray[i]));
        }

        return cars;
    }
}
