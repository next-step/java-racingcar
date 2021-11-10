package com.kakao.racingcar.domain.car;

import com.kakao.racingcar.domain.car.Car;
import com.kakao.racingcar.domain.car.CarCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarCollectionTest {
    @Test
    @DisplayName("입력한 유저이름만큼의 차 저장소를 생성한다.")
    void carCollectionConstructor() {
        CarCollection carCollection = new CarCollection(Arrays.asList("jyami","mj","kim","minjeong"));
        assertThat(carCollection.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("처 저장소에서 position이 가장 큰 차들의 리스트를 반환한다.")
    void carCollectionWinner() {
        CarCollection carCollection = new CarCollection(Arrays.asList("jyami","mj","kim","minjeong"));
        carCollection.tryMoveCars(Arrays.asList(10,0,0,10));
        assertThat(carCollection.getWinner()).extracting(Car::getUserName).containsExactly("jyami", "minjeong");
    }

}
