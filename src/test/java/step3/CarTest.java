package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void setUp(){
        car = new Car(1);
    }

    @Test
    @DisplayName("RaceRoulette 값이 4보다 작으면 차량은 움직이지 않는다")
    void noMoving(){
        car.move(lessThan4);
        car.move(lessThan4);
        car.move(lessThan4);

        assertThat(car.getMovingDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("RaceRoulette 값이 4이상이면 차량은 전진한다")
    void moving(){
        car.move(greaterThan3);
        car.move(greaterThan3);
        car.move(greaterThan3);

        assertThat(car.getMovingDistance()).isEqualTo(3);
    }

    private RaceRoulette lessThan4 = () -> new Random().nextInt(3);
    private RaceRoulette greaterThan3 = () -> new Random().nextInt(6) + 4;
}