package racingcar.model.factory;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsFactoryTest {

    @Nested
    class create_메서드는 {

        @Nested
        class _5자가_넘는_자동차_이름이_주어질_경우 {

            @ParameterizedTest
            @ValueSource(strings = {"123456,12345,12345"})
            void IllegalArgumentException을_던진다(String carNames) {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> CarsFactory.create(carNames));
            }
        }

        @Nested
        class _5자이하_자동차_이름이_주어질_경우 {

            @ParameterizedTest
            @ValueSource(strings = {"12345,12345,12345"})
            void Cars_타입을_리턴한다(String carNames) {
                assertThat(CarsFactory.create(carNames))
                        .isInstanceOf(Cars.class);
            }
        }
    }
}
