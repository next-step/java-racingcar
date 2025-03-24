package com.nextstep.camp.racing.application.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.nextstep.camp.racing.domain.vo.Car;

public class CarResponse {

    private final List<MoveResponse> moves;

    private CarResponse(Car car) {
        this.moves = car.getMoves()
            .stream()
            .map(MoveResponse::of)
            .collect(Collectors.toList());
    }

    public static CarResponse of(Car car) {
        return new CarResponse(car);
    }

    public List<MoveResponse> getMoves() {
        return moves;
    }

    @Override
    public String toString() {
        return "CarResponse{" +
            "moves=" + moves +
            '}';
    }
}
