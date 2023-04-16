package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {


    @Test
    public void 전진테스트() {
        Car car = new Car();
        int random = 5;
        car.move(random);
        assertThat(car.getProgress()).isEqualTo(1);
    }

    @Test
    public void 랜덤값_검증() {
        int randomFalse = 1;
        assertThat(Car.moveAvailable(randomFalse)).isFalse();
        int randomTrue = 5;
        assertThat(Car.moveAvailable(randomTrue)).isTrue();
    }


}
