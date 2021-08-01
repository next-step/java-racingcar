package com.racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NamedCarTest {
    @Test
    @DisplayName("이름 붙어진 자동차 객체 생성 테스트")
    public void create() {
        //given
        String name = "test";
        int id = 0;

        //when
        NamedCar car = new NamedCar(id, name);

        //then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("5글자 이상 자동차 이름 붙힐 시 테스트")
    public void exceedNameLength() {
        //given
        String name = "12345";
        int id = 0;

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new NamedCar(id, name);
        });
    }
}
