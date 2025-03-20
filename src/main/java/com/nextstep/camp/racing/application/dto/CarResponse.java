package com.nextstep.camp.racing.application.dto;

import java.util.stream.Collectors;

import com.nextstep.camp.racing.domain.vo.Car;

public class CarResponse {
    private final MovesResponse moves;

    private CarResponse(Car car) {
        this.moves = MovesResponse.of(
            car.getMoves()
                .stream()
                .map(MoveResponse::of)
                .collect(Collectors.toList()));
    }

    public static CarResponse of(Car car) {
        return new CarResponse(car);
    }

    public MovesResponse getMoves() {
        return moves;
    }

    @Override
    public String toString() {
        return "CarResponse{" +
            "moves=" + moves +
            '}';
    }
}
