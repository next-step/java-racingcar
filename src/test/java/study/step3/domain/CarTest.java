package study.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.step3.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final int STOP = 0;
    private Car car;

    @BeforeEach
    void init() {
        car = new Car();
    }

    @Test
    void moveOrStop_전진() {
        //given
        int randomValue = 5;

        //when
        int distance = car.moveOrStop(randomValue);

        //then
        assertThat(distance).isEqualTo(randomValue);
    }

    @Test
    void moveOrStop_정지() {
        //given
        int randomValue = 3;

        //when
        int distance = car.moveOrStop(randomValue);

        //then
        assertThat(distance).isEqualTo(STOP);
    }
}
