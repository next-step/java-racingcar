package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @DisplayName("생성자로 이름을 받는다.")
    @ValueSource(strings = {"짱구", "철수", "맹구"})
    void newInstance(String input) {
        Car car = new Car(input);

        assertThat(car).isEqualTo(new Car(input));
    }

    @Test
    @DisplayName("이름의 길이가 5가 넘으면 예외가 발생한다")
    void longNameLength() {
        assertThatThrownBy(() -> new Car("아주길고도긴이름"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("차는 움직인다")
    void move() {
        Car car = new Car("test");

        car.move(new RandomNumber());

        assertThat(car).isEqualTo(new Car("test", 1));
    }

    @Test
    void isWinner() {
        Car car = new Car("test", 2);
        Car max = new Car("temp", 2);
        assertThat(car.isWinner(max)).isTrue();
    }

    @Test
    void findMaxPosition() {
        Car car = new Car("test", 2);
        int maxPosition = car.findMaxPosition(1);

        assertThat(maxPosition).isEqualTo(2);
    }
}