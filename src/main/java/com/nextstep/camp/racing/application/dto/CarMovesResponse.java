package com.nextstep.camp.racing.application.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.nextstep.camp.racing.domain.vo.*;

public class CarMovesResponse {
    private final CarResponse car;
    private final List<Boolean> moves;

    private CarMovesResponse(Car car, List<Boolean> values) {
        this.car = CarResponse.of(car);
        this.moves = values;
    }

    private CarMovesResponse(CarMoves moves) {
        this.car = CarResponse.of(moves.getCar());
        this.moves = moves.getMoves().stream()
                .map(Move::isMove)
                .collect(Collectors.toList());
    }

    public static CarMovesResponse of(CarMoves moves) {
        return new CarMovesResponse(moves);
    }

    public static CarMovesResponse of(Car car, List<Boolean> values) {
        return new CarMovesResponse(car, values);
    }

    public List<Boolean> getMoves() {
        return moves;
    }
}
