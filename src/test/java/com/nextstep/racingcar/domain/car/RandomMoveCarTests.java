package com.nextstep.racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveCarTests {
    private RandomMoveCar newRandomMoveCar;
    private MoveLength zero;
    private MoveLength one;

    @BeforeEach
    public void setup() {
        newRandomMoveCar = new RandomMoveCar();
        zero = MoveLength.createZero();
        one = MoveLength.createByInt(1);
    }

    @DisplayName("처음 만들어진 차량은 움직인 거리가 0이다.")
    @Test
    void newCarTest() {
        assertThat(newRandomMoveCar.getMoveLength()).isEqualTo(zero);
    }

    @DisplayName("4 이상의 값을 입력받은 차량은 움직이고 움직인 거리가 1증가한다.")
    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6, 7, 8 })
    void moveCarTest(int value) {
        assertThat(newRandomMoveCar.getMoveLength()).isEqualTo(zero);
        newRandomMoveCar.move(Power.generateByInt(value));
        assertThat(newRandomMoveCar.getMoveLength()).isEqualTo(one);
    }

    @DisplayName("4 미만의 값을 입력받은 차량은 움직이지 않고 움직인 거리가 변하지 않는다..")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3 })
    void moveCarFailTest(int value) {
        assertThat(newRandomMoveCar.getMoveLength()).isEqualTo(zero);
        newRandomMoveCar.move(Power.generateByInt(value));
        assertThat(newRandomMoveCar.getMoveLength()).isEqualTo(zero);
    }
}
