package study.step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    public static final int STOP = 0;
    private Car car;

    @Test
    void moveForward_전진() throws Exception {
        //given
        car = new Car("sonata",
                new LessThanMoveCondition(4, new StaticMove(5)));

        //when
        car.moveForward();

        //then
        assertThat(car.getPosition()).isEqualTo(Car.GO);
    }

    @Test
    void moveForward_멈춤() throws Exception {
        //given
        car = new Car("sonata",
                new LessThanMoveCondition(4, new StaticMove(3)));

        //when
        car.moveForward();

        //then
        assertThat(car.getPosition()).isEqualTo(STOP);
    }
}
