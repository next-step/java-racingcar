package com.nextlevel.kky.racing.service;

import com.nextlevel.kky.racing.core.Car;
import com.nextlevel.kky.racing.core.IntegerGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {

    private final IntegerGenerator integerGenerator;

    public CarService(IntegerGenerator integerGenerator) {
        this.integerGenerator = integerGenerator;
    }

    public List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(name -> new Car(name, integerGenerator, 0))
                .collect(Collectors.toList());
    }
}
