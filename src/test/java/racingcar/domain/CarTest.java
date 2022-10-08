package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    @DisplayName("이름을 입력하면 자동차가 생성되고, 그 자동차가 움직인다면 해당 자동차의 위치가 1 증가한다.")
    void moveTest(String input) {
        Car car = new Car(input);
        car.moves(() -> true);

        assertThat(car).isEqualTo(new Car(input, 1));
    }

    @ParameterizedTest
    @ValueSource(strings = {"conan"})
    @DisplayName("이름을 입력하면 자동차가 생성되고, 그 자동차가 정지한다면 해당 자동차의 위치가 0이다.")
    void stopTest(String input) {
        Car car = new Car(input);
        car.moves(() -> false);

        assertThat(car).isEqualTo(new Car(input, 0));
    }
}
