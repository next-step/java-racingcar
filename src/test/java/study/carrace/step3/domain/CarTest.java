package study.carrace.step3.domain;

import org.junit.jupiter.api.Test;
import study.carrace.step3.domain.exception.IllegalCarNameException;


import static org.assertj.core.api.Assertions.*;


class CarTest {
    @Test
    void move() {
        // given
        Car car = new Car("test", mockMoveStrategy(true));

        // when
        car.moveOrStop();

        // then
        assertThat(car.currentPosition()).isEqualTo("test : -");
    }

    @Test
    void stop() {
        // given
        Car car = new Car("test", mockMoveStrategy(false));

        // when
        car.moveOrStop();

        // then
        assertThat(car.currentPosition()).isEqualTo("test : ");
    }

    @Test
    void name_longer_than_5_characters_then_throw_IllegalCarNameException() {
        // given
        String invalidName = "more_than_five_character";

        // when, then
        assertThatThrownBy(() -> new Car(invalidName, null))
                .isInstanceOf(IllegalCarNameException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다: " + invalidName);
    }

    private MoveStrategy mockMoveStrategy(boolean movable) {
        return () -> movable;
    }
}