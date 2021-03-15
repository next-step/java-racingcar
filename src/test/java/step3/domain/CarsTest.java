package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("Car 객체 제대로 가져오는지 테스트")
    void getCars() {
        // given
        List<Car> expected = new ArrayList<>();
        expected.add(new Car());
        expected.add(new Car());

        // when
        Cars cars = new Cars(expected);
        List<Car> actual = cars.getCars();

        // then
        assertThat(expected).isEqualTo(actual);
    }
}
