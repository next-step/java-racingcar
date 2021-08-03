package carracing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarFactoryTest {

    @Test
    @DisplayName("정해진 count를 받으면 count만큼의 자동차 list를 반환할 수 있다.")
    void makeCarTest() {

        // given
        int count = 5;

        // when
        List<Car> result = CarFactory.makeCars(count);

        // then
        assertThat(result.size()).isEqualTo(5);
    }
}