package com.kakao.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarCollectionTest {
    @Test
    @DisplayName("입력한 숫자만큼의 차 저장소를 생성한다.")
    void carCollectionConstructor() {
        CarCollection carCollection = new CarCollection(6);
        assertThat(carCollection.size()).isEqualTo(6);
    }

}
