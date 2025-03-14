package com.nextstep.camp.racing.domain.vo;

import java.util.Random;

public class Move {
    private final boolean value;

    private Move() {
        int randomNumber = new Random().nextInt(10);
        this.value = randomNumber > 4;
    }

    public static Move decide() {
        return new Move();
    }

    public boolean isMove() {
        return value;
    }
}
