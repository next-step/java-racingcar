package com.nextstep.camp.racing.application.dto;

import com.nextstep.camp.racing.domain.vo.Lap;

import java.util.List;
import java.util.stream.Collectors;

public class LapResponse {
    private final List<MovesResponse> moves;

    private LapResponse(List<MovesResponse> moves) {
        this.moves = moves;
    }

    public static LapResponse of(Lap lap) {
        return new LapResponse(lap.getAllMoves()
                .stream()
                .map(MovesResponse::of)
                .collect(Collectors.toList()));
    }

    public static LapResponse of(List<MovesResponse> moves) {
        return new LapResponse(moves);
    }

    public List<MovesResponse> getAllMoves() {
        return moves;
    }
}
