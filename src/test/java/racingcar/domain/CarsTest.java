package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("입력한 이름으로 자동차들을 생성한다")
    void createCarsByNames() {
        Cars cars = new Cars(List.of("pobi", "conan"));

        assertThat(cars.getStatuses())
                .containsExactly(new CarStatus("pobi", 0), new CarStatus("conan", 0));
    }

    @Test
    @DisplayName("모든 자동차가 생성된 숫자로 한 번씩 전진을 판단한다")
    void moveAllCars() {
        Cars cars = new Cars(List.of("pobi", "conan"));

        cars.move(() -> 4);

        assertThat(cars.getStatuses())
                .containsExactly(new CarStatus("pobi", 1), new CarStatus("conan", 1));
    }
}
