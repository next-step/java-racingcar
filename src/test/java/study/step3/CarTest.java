package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(0);
    }
    @Test
    void 초기_포지션_테스트() {
        assertThat(car.getPosition())
                .isEqualTo(0);
    }

    @Test
    void 이동후_포지션_테스트() {
        car.move();
        car.move();
        car.move();
        assertThat(car.getPosition()).isEqualTo(3);
    }


    @Test
    void 랜덤값이_4이상_9이하_테스트() {

        assertThat(car.canMove(4,9)).isTrue();
    }


    @Test
    void 랜덤값이_4미만_테스트() {
        assertThat(car.canMove(0,3)).isFalse();
    }


}