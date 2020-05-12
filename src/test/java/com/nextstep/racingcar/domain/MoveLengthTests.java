package com.nextstep.racingcar.domain;

import com.nextstep.racingcar.domain.car.MoveLength;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoveLengthTests {
    @DisplayName("최초 생성 시 0인 상태로 생성할 수 있어야 한다.(패키지 외부 사용 용도)")
    @Test
    void newMoveLengthTest() {
        assertThat(MoveLength.createZero().toInt()).isEqualTo(0);
    }

    @DisplayName("값을 입력받아 생성할 수 있다.(패키지 내부 사용 용도")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 4, 5 })
    void newMoveLengthByValueTest(int value) {
        assertThat(MoveLength.createByInt(value).toInt()).isEqualTo(value);
    }

    @DisplayName("0 이하의 값으로 객체 생성 불가능")
    @ParameterizedTest
    @ValueSource(ints = { -1, -2, -10 })
    void newMoveLengthFailWithNegativeNumberTest(int negativeNumber) {
        assertThatThrownBy(() -> MoveLength.createByInt(negativeNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("증가 연산 수행 시 1씩 값이 증가함")
    @Test
    void increaseTest() {
        MoveLength one = MoveLength.createZero().increase();
        assertThat(one.toInt()).isEqualTo(1);
    }

    @DisplayName("동등성 비교 수행 여부 확인")
    @Test
    void equalTest() {
        MoveLength zero1 = MoveLength.createZero();
        MoveLength zero2 = MoveLength.createZero();
        assertThat(zero1.equals(zero2)).isTrue();
    }
}
