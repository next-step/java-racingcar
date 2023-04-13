package study.step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void getPosition_초기_포지션_테스트() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void getName_테스트() {
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void move_이동후_포지션_테스트() {
        car.move();
        car.move();
        car.move();
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:true", "2:false"}, delimiter = ':')
    void canMove_테스트(int input, boolean expected) {
        assertThat(car.canMove(input)).isEqualTo(expected);
    }
}