package com.nextstep.camp.racing.application.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.nextstep.camp.racing.domain.vo.Lap;

public class LapResponse {
    private final List<CarMovesResponse> moves;

    private LapResponse(List<CarMovesResponse> moves) {
        this.moves = moves;
    }

    public static LapResponse of(Lap lap) {
        return new LapResponse(lap.getCarMoves()
                .stream()
                .map(CarMovesResponse::of)
                .collect(Collectors.toList()));
    }

    public static LapResponse of(List<CarMovesResponse> moves) {
        return new LapResponse(moves);
    }

    public List<CarMovesResponse> getCarMoves() {
        return moves;
    }
}
