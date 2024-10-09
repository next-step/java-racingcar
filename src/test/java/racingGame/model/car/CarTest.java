package racingGame.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("기본 생성자로 객체를 생성한 경우, 포지션은 0 이다")
    void 생성자_테스트() {
        Car car = new Car();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("생성자는 입력이 유효한 경우, 객체를 생성한다.")
    void 생성자_테스트_2(final int position) {
        Car car = new Car(position);

        assertThat(car.getPosition()).isEqualTo(position);
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1})
    @DisplayName("생성자는 입력이 유효하지 않은 경우, 예외를 반환한다.")
    void 생성자_예외_테스트(final int position) {

        assertThatThrownBy(() -> new Car(position))
                .isInstanceOf(RuntimeException.class);

    }

}
