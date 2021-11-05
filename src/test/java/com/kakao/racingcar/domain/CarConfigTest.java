package com.kakao.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarConfigTest {

    @Test
    @DisplayName("입력한 숫자 크기만큼의 랜덤 숫자를 생성한다.")
    void randomNumberGenerator() {
        List<Integer> integers = CarConfig.randomNumberGenerator(10);
        assertThat(integers.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("랜덥생성기에서 만들어진 값은 0이상 10미만이다")
    void randomNumberGeneratorValue() {
        List<Integer> integers = CarConfig.randomNumberGenerator(100);
        for(int value : integers){
            assertThat(value >= 0 && value < 10).isTrue();
        }
    }
}
