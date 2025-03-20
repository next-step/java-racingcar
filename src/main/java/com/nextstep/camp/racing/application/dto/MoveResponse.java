package com.nextstep.camp.racing.application.dto;

import com.nextstep.camp.racing.domain.vo.Move;

public class MoveResponse {
    private final boolean move;

    private MoveResponse(Move move) {
        this.move = move.isMove();
    }

    public static MoveResponse of(Move move) {
        return new MoveResponse(move);
    }

    public boolean isMove() {
        return move;
    }

    @Override
    public String toString() {
        return "MoveResponse{" +
            "move=" + move +
            '}';
    }
}
