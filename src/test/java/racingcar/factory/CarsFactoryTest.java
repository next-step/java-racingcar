package racingcar.factory;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsFactoryTest {

    @Nested
    class create_메서드는 {

        @Test
        void 자동차_숫자만큼_생성한다() {
            List<Car> cars = CarsFactory.create(3);
            assertThat(cars).hasSize(3);
        }
    }
}
