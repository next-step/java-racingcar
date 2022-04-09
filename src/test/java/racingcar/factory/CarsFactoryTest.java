package racingcar.factory;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarsFactoryTest {

    @Nested
    class create_메서드는 {

        @Test
        void 생성한_자동차들을_리턴한다() {
            int randomNumber = getRandomNumber();
            assertThat(CarsFactory.create(randomNumber))
                    .isInstanceOf(Cars.class);
        }

        private int getRandomNumber() {
            return new Random().nextInt(10);
        }
    }
}
