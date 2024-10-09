package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void 사용자_입력값_만큼의_자동차를_생성할_수_있다(final int userInput) {
        Cars cars = new Cars(userInput);
        assertThat(cars.getCars().size()).isEqualTo(userInput);
    }
}
