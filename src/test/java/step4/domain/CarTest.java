package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"violin", ""})
    @DisplayName("자동차 이름 입력 테스트(공백)")
    void 자동차_이름입력_테스트_범위_밖(String input) {
        Assertions.assertThatThrownBy(() -> new Car(input)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("길이가 1이상 5이하인 문자열이여야 함");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    @DisplayName("움직임 가능한 경우 테스트")
    void 자동차_움직임_가능(String input) {
        Car car = new Car(input);

        car.move(() -> 5);

        Assertions.assertThat(car.getLocation()).isEqualTo(2);

    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    @DisplayName("움직임 가능한 경우 테스트")
    void 자동차_움직임_불가능(String input) {
        Car car = new Car(input);

        car.move(() -> 1);

        Assertions.assertThat(car.getLocation()).isEqualTo(1);

    }

}
