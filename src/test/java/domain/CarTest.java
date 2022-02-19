package domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    public static final String TEST_NAME = "박찬우";
    public Car car;

    @BeforeEach
    void setUp() {
        car = new Car(TEST_NAME);
    }

    @Test
    void 이름을_가질수_있다() {
        assertThat(car.getName()).isEqualTo(TEST_NAME);
    }

    @Test
    void 위치의_초기값은_0이다() {
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 전진할_수_있다() {
        car.move();
        car.move();
        assertThat(car.getDistance()).isEqualTo(2);
    }

    @Test
    void 현재이름_위치를_String으로_반환() {
        car.move();
        car.move();
        car.move();
        assertThat(car.convertCarStatus()).isEqualTo("박찬우 : ---");
    }
}
