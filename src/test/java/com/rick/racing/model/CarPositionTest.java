package com.rick.racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarPositionTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 12, 66, 100})
    @DisplayName("인스턴스 정상 생성 확인")
    public void create(int value) {
        final CarPosition carPositionA = CarPosition.create(value);
        final CarPosition carPositionB = CarPosition.create(value);

        assertThat(carPositionA.equals(carPositionB))
            .isTrue();
    }

    @Test
    @DisplayName("increase 메소드 동작 테스트")
    public void increaseTest() {
        final int position = 23;

        CarPosition carPositionA = CarPosition.create(position);
        carPositionA.increase();
        CarPosition carPositionB = CarPosition.create(position + 1);

        assertThat(carPositionA.equals(carPositionB))
            .isTrue();
    }
}
