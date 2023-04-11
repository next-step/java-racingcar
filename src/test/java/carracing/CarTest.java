package carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    int randomNumber;

    Car car;

    @BeforeEach
    void setUpRandomRangeAndCar() {
        Random random = new Random();
        int bound = 10;
        randomNumber = random.nextInt(bound);
        car = new Car();
    }

    @Test
    void 자동차_이동거리_랜덤값_부여() {
        car.assignRandomDistance(randomNumber);
        assertThat(car.getDistance()).isNotNull();
    }

    @Test
    void 자동차_이동가능여부() {
        Car car = new Car();
        car.assignRandomDistance(randomNumber);
        Boolean movable = car.isMovable();
        assertThat(car.getDistance() >= 4).isEqualTo(movable);
    }

    @Test
    @DisplayName("랜덤값이 4미만일 경우 움직일 수 없다.")
    void 랜덤값_4미만() {
        car.assignRandomDistance(3);
        assertThat(car.isMovable()).isFalse();
    }

    @Test
    @DisplayName("랜덤값이 4이상일 경우 움직일 수 있다.")
    void 랜덤값_4이상() {
        car.assignRandomDistance(4);
        assertThat(car.isMovable()).isTrue();
    }

    @Test
    @DisplayName("자동차가 이동할 수 있는 상태면 한칸 이동한다.")
    void 자동차_이동거리_5() {
        car.assignRandomDistance(5);
        car.move();
        assertThat(car.getMovedState()).isEqualTo("-");
    }

    @Test
    @DisplayName("자동차가 이동할 수 있는 상태가 아니면 이동하지 않는다.")
    void 자동차_이동거리_3() {
        car.assignRandomDistance(3);
        car.move();
        assertThat(car.getMovedState()).isEmpty();
    }

}