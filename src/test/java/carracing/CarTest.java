package carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    int randomNumber;

    @BeforeEach
    void setUpRandomRange() {
        Random random = new Random();
        int bound = 10;
        randomNumber = random.nextInt(bound);
    }

    @Test
    void 자동차_이동거리_랜덤값_부여() {
        Car car = new Car();
        car.assignRandomDistance(randomNumber);
        assertThat(car.getDistance()).isNotNull();
    }

    @Test
    void 자동차_이동가능여부() {
        Car car = new Car();
        car.assignRandomDistance(randomNumber);
        Boolean movable = car.isMovable();
        assertThat(car.getDistance() >= 4).isEqualTo(movable == true);
    }

    @Test
    @DisplayName("랜덤값이 4미만일 경우 움직일 수 없다.")
    void 랜덤값_4미만() {
        Car car = new Car();
        car.assignRandomDistance(3);
        assertThat(car.isMovable()).isFalse();
    }

    @Test
    @DisplayName("랜덤값이 4이상일 경우 움직일 수 있다.")
    void 랜덤값_4이상() {
        Car car = new Car();
        car.assignRandomDistance(4);
        assertThat(car.isMovable()).isTrue();
    }
}