package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void move_메서드는_주어진_전략에_따라_자동차를_움직입니다() {

        Car car = new Car(Position::moveOneStep);
        MoveStrategy fakeAbsoluteMoveStrategy = (Position::moveOneStep);

        Car expected = new Car(1, fakeAbsoluteMoveStrategy);
        Car result = car.move();

        assertThat(result).isEqualTo(expected);
    }

}
