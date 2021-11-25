package com.rick.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"value", "test1", "hello", "sdf"})
    @DisplayName("인스턴스 정상 생성 확인")
    public void create(String name) {
        final CarName carNameA = CarName.create(name);
        final CarName carNameB = CarName.create(name);

        assertThat(carNameA).isEqualTo(carNameB);
    }

    @Test
    @DisplayName("자동차 이름 5자 초과 불가")
    public void nameLenghtCanNotBeGreaterThan5() {
        final String carNameMoreThan5Chars = "abcdef";
        assertThatIllegalArgumentException()
            .isThrownBy(() -> CarName.create(carNameMoreThan5Chars));
    }

    @Test
    @DisplayName("자동차 이름 공백 불가")
    public void emptyName() {
        final String emptyName = "";

        assertThatIllegalArgumentException()
            .isThrownBy(() -> CarName.create(emptyName));
    }
}
