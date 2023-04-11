package study.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final int STOP = 0;
    private Car car;

    @BeforeEach
    void init() {
        car = new Car(new LessThanMoveCondition(4));
    }

    @Test
    void moveOrStop_전진() {
        //given
        int distance = 5;

        //when
        car.moveForward(distance);

        //then
        assertThat(car.getPosition()).isEqualTo(Car.GO);
    }

    @Test
    void moveOrStop_정지() {
        //given
        int distance = 3;

        //when
        car.moveForward(distance);

        //then
        assertThat(car.getPosition()).isEqualTo(STOP);
    }
}
