package com.nextstep.camp.racing.application.dto;

import java.util.List;

public class CarsResponse {
    private final List<CarResponse> values;

    private CarsResponse(List<CarResponse> values) { this.values = values; }

    public static CarsResponse of(List<CarResponse> cars) {
        return new CarsResponse(cars);
    }

    public List<CarResponse> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "CarsResponse{" +
            "cars=" + values +
            '}';
    }
}
