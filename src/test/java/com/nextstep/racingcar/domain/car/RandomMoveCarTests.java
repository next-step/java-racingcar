package com.nextstep.racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveCarTests {
    private RandomMoveCar newRandomMoveCar;
    private MoveLength zero;

    @BeforeEach
    public void setup() {
        newRandomMoveCar = new RandomMoveCar();
        zero = MoveLength.createZero();
    }

    @DisplayName("처음 만들어진 차량은 움직인 거리가 0이다.")
    @Test
    void newCarTest() {
        assertThat(newRandomMoveCar.getMoveLength()).isEqualTo(zero);
    }

    @DisplayName("차량은 움직일 수 있으나 거리가 변화하지 않을 수 있다.")
    @Test
    void moveCarTest() {
        assertThat(newRandomMoveCar.getMoveLength()).isEqualTo(zero);
        newRandomMoveCar.move();
        assertThat(newRandomMoveCar.getMoveLength().toInt() >= 0).isTrue();
    }
}
