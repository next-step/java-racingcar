package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 랜덤값에_따라서_위치가_변하는지_확인() {
        Car car = new Car("Test");
        assertThat(car.drive(1)).isEqualTo(0);
        assertThat(car.drive(2)).isEqualTo(0);
        assertThat(car.drive(3)).isEqualTo(0);
        assertThat(car.drive(4)).isEqualTo(1);
        assertThat(car.drive(5)).isEqualTo(2);
        assertThat(car.drive(6)).isEqualTo(3);
        assertThat(car.drive(7)).isEqualTo(4);
        assertThat(car.drive(8)).isEqualTo(5);
    }
}