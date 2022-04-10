package racingcar.model.factory;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class CarsFactoryTest {

    @Nested
    class create_메서드는 {

        @Test
        void Cars_타입을_리턴한다() {
            assertThat(CarsFactory.create(3))
                    .isInstanceOf(Cars.class);
        }
    }
}
