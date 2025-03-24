package com.nextstep.camp.racing.application.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.nextstep.camp.racing.domain.entity.Racing;

public class RacingResponse {

    private final List<CarResponse> cars;

    private RacingResponse(Racing racing) {
        this.cars = racing.getCars()
            .stream()
            .map(CarResponse::of)
            .collect(Collectors.toList());
    }

    public static RacingResponse of(Racing racing) {

        return new RacingResponse(racing);
    }

    public List<CarResponse> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        return "RacingResponse{" +
            "cars=" + cars +
            '}';
    }
}
