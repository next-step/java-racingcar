package com.rick.racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"value", "test1", "hello", "sdf"})
    @DisplayName("인스턴스 정상 생성 확인")
    public void create(String name) {
        final CarName carNameA = CarName.create(name);
        final CarName carNameB = CarName.create(name);

        assertThat(carNameA.equals(carNameB)).isTrue();
    }
}
