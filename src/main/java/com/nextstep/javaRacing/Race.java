package com.nextstep.javaRacing;

import java.util.List;

public class Race {

    protected List<Car> cars;
    protected int turns;

    protected Race(List<Car> cars, int turns){
        this.cars = cars;
        this.turns = turns;
    }
}
