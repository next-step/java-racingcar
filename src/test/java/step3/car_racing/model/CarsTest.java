package step3.car_racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차 리스트를 생성하고 길이를 확인한다.")
    void makeCarList() {

        // given
        List<String> carNameList = List.of("이상원", "원상이");

        // when
        Cars cars = new Cars(carNameList);

        // then
        assertThat(cars.getCarList().size()).isEqualTo(carNameList.size());
    }

}