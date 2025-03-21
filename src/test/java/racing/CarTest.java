package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @ParameterizedTest
    @CsvSource(value = {"1:2", "2:3", "3:4"}, delimiter = ':')
    @DisplayName("Car 의 이동한 횟수에 맞춰 현재 위치가 반영된다.")
    public void print_car_currentPosition(int moveCount, int expected) {
        // given
        Car car = new Car();

        // when
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        // then
        int actual = car.getPosition();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 이름이 MaxNameLength 를 초과하는 경우 IllegalArgumentException 이 발생한다.")
    public void car_throws_IllegalArgumentException_whenNameIsOverMaxNameLength() {
        // given
        Car car = new Car();
        String carName = "ABCDEF";

        // when & then
        assertThatThrownBy(() -> car.registerName(carName)).isInstanceOf(Exception.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }
}