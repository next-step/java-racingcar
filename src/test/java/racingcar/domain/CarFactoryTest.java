package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarFactoryTest {

    @DisplayName("유일한 이름으로 자동차를 생성한다.")
    @Test
    void uniqueNameTest() {
        //given
        List<String> duplicatedNames = List.of("국인", "국인");

        //when
        Cars cars = CarFactory.create(duplicatedNames, () -> true);

        //then
        assertThat(cars.size()).isEqualTo(1);
        assertThat(cars.containsCarName("국인")).isTrue();
    }
}