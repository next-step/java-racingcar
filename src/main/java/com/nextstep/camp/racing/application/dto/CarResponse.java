package com.nextstep.camp.racing.application.dto;

import com.nextstep.camp.racing.domain.vo.Car;

public class CarResponse {
    private final String name;

    private CarResponse(String name) {
        this.name = name;
    }

    public static CarResponse of(Car car) {
        return new CarResponse(car.getName().getValue());
    }

    public String getName() {
        return name;
    }
}
