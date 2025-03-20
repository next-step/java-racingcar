package com.nextstep.camp.racing.application.dto;

import java.util.List;

public class MovesResponse {
    private final List<MoveResponse> values;

    private MovesResponse(List<MoveResponse> values) { this.values = values; }

    public static MovesResponse of(List<MoveResponse> move) {
        return new MovesResponse(move);
    }

    @Override
    public String toString() {
        return "MovesResponse{" +
            "move=" + values +
            '}';
    }

    public List<MoveResponse> getValues() {
        return values;
    }
}
