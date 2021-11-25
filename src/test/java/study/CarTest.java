package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.IllegalFormatException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("움직일 수 있는 조건이 주어지면 전진한다")
    void shouldIncreasePosition() {
        Car car = new Car();
        car.move(true);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("움직일 수 있는 조건을 만족하지 않으면 전진하지 않는다")
    void shouldHaveSamePosition() {
        Car car = new Car();
        car.move(false);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("5자 이하의 자동차 이름을 자동차에 부여한다")
    void shouldEqualInputName() {
        String name = "hazel";
        Car car = new Car();
        car.name(name);

        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getName().length()).isLessThanOrEqualTo(5);
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외를 던진다")
    void shouldThrowExceptionWhenNameIsOverFiveCharacters() {
        String name = "monica";
        Car car = new Car();

        assertThatThrownBy(() -> car.name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}