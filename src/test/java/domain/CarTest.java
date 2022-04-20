package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @DisplayName("자동차 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "abcde","1", "12345", "#", "@#$%@", "@1#4%", "a1!@d"})
    void createCarTest(String carName) {
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayName("자동차 생성 테스트 - 실패케이스")
    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef", "@#$%^&", "123456"})
    void createCarFailTest(String carName) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void carMoveTest(boolean movable, int moveDistance) {
        Car car = new Car("car");
        Position afterPosition = new Position();
        ReflectionTestUtils.setField(afterPosition, "position", moveDistance);

        car.move(TestMoveStrategy.getInstance(movable));

        assertThat(car.equalPosition(afterPosition)).isTrue();
    }
}
