package com.ssabae.nextstep.racingcar.step03.domain;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-06
 */
public class Car {

    private int moveCount;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(MoveState state) {
        if (state == MoveState.GO) {
            moveCount++;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getPrintString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            output.append("-");
        }
        return output.toString();
    }
}
