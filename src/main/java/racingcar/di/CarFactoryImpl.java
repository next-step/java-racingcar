package racingcar.di;

import racingcar.domain.Car;
import racingcar.domain.NormalEngine;
import racingcar.domain.RacingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactoryImpl implements CarFactory{
    @Override
    public List<Car> makeCars(String[] names) {
        return Arrays
                .stream(names)
                .map(name-> new RacingCar(name, new NormalEngine()))
                .collect(Collectors.toList());
    }
}