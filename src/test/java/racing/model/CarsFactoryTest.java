package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsFactoryTest {

    @Test
    @DisplayName("구분자(,) 기준으로 자동차 이름을 잘라서 racing.model.Cars 객체를 생성한다.")
    void createCars() {
        final String input = "pobi,crong,honux";
        final Cars expected = new Cars(List.of(new Car("pobi"), new Car("crong"), new Car("honux")));
        assertThat(CarsFactory.createCars(input)).isEqualTo(expected);
    }
}