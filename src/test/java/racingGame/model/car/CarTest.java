package racingGame.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("기본 생성자로 객체를 생성한 경우, 포지션은 0 이다")
    void 생성자_테스트() {
        Car car = new Car("a");

        assertThat(car.getName()).isEqualTo("");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:a", "3:b", "2:c"}, delimiter = ':')
    @DisplayName("생성자는 입력이 유효한 경우, 객체를 생성한다.")
    void 생성자_테스트_2(final int position, final String name) {
        Car car = new Car(position, name);

        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1:a", "1:666666", "2:7777777"}, delimiter = ':')
    @DisplayName("생성자는 입력이 유효하지 않은 경우, 예외를 반환한다.")
    void 생성자_예외_테스트(final int position, final String name) {
        assertThatThrownBy(() -> new Car(position, name))
                .isInstanceOf(RuntimeException.class);
    }

}
