package com.nextstep.camp.racing.application.dto;

import com.nextstep.camp.racing.domain.vo.Move;
import com.nextstep.camp.racing.domain.vo.Moves;

import java.util.List;
import java.util.stream.Collectors;

public class MovesResponse {
    private final List<Boolean> values;

    private MovesResponse(Moves values) {
        this.values = values.stream()
                .map(Move::isMove)
                .collect(Collectors.toList());
    }

    private MovesResponse(List<Boolean> values) {
        this.values = values;
    }

    public static MovesResponse of(Moves moves) {
        return new MovesResponse(moves);
    }

    public static MovesResponse of(List<Boolean> values) {
        return new MovesResponse(values);
    }

    public List<Boolean> getValues() {
        return values;
    }
}
