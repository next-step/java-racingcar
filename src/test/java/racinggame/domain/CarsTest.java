package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {

    @DisplayName("자동차 이름들을 가지고 자동차 정상 생성 테스트")
    @Test
    void 자동차_생성_테스트() {
        //given
        List<String> carName = Arrays.asList("a","b");

        //when
        Cars cars = Cars.createCars(carName);

        //then
        assertThat(cars.getCarList()).hasSize(2);
    }

    @DisplayName("자동차 이름이 없는 경우 자동차 생성 불가 예외 테스트")
    @Test
    void 자동차이름_Null_생성_불가_예외_테스트() {
        //given
        List<String> carName = Arrays.asList("a","");

        //when
        assertThrows(IllegalArgumentException.class, () -> Cars.createCars(carName));
    }

    @DisplayName("자동차 이름이 한개의 경우 경주 불가 예외 테스트")
    @Test
    void 자동차_1개_경주_불가_예외_테스트() {
        //given
        List<String> carName = Arrays.asList("a");

        //when
        assertThrows(IllegalArgumentException.class, () -> Cars.createCars(carName));
    }
}
