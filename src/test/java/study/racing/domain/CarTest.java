package study.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차는 4 이상의 값을 받으면 전진한다.")
    void moveCarTest() {
        // given
        Car car = new Car(new Name("car1"), new Position(0));

        // when
        car.move(4);

        // then
        assertThat(car).isEqualTo(new Car(new Name("car1"), new Position(1)));
    }

    @Test
    @DisplayName("3 이하의 값을 받으면 전진하지 않는다.")
    void doNotMoveTest() {
        // given
        Car car = new Car(new Name("car1"), new Position(0));

        // when
        car.move(3);

        // then
        assertThat(car).isEqualTo(new Car(new Name("car1"), new Position(0)));
    }
}
