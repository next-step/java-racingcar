package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("쉼표로 구분한 자동차 이름으로 자동차 리스트를 생성한다.")
    void from(){
        Cars cars = Cars.from("pobi,crong,honux");
        assertThat(cars.getCarList()).isEqualTo(Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux")));
    }

}