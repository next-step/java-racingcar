package step5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    @Test
    public void 전진테스트() {
        Car car = new Car("test");
        car.move(1);
        assertThat(car.isEqualsProgress(1)).isTrue();
    }

    @Test
    public void 랜덤값_검증_실패() {
        int randomTrue = 5;
        assertThat(Car.movable(randomTrue)).isTrue();
    }

    @Test
    public void 랜덤값_검증_성공() {
        int randomTrue = 5;
        assertThat(Car.movable(randomTrue)).isTrue();
    }


}
