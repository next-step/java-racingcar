package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("TestCar");
    }

    @Test
    @DisplayName("정상적인 자동차 이동 테스트")
    void carMoveTestFunction() {
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("정상적인 자동차 비 이동 테스트")
    void carStopTestFunction() {
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이름 설정 테스트")
    void carNameTestFunction() {
        String carName = car.getName();
        assertThat(carName).isEqualTo("TestCar");
    }

    @Test
    @DisplayName("자동차 위치 동일 한지 확인하는 함수 테스트")
    void carIsEqualsPositionTestFunction() {
        car.move(5);
        car.move(5);
        car.move(5);

        assertThat(car.isEqualPosition(4)).isEqualTo(true);
    }

    @Test
    @DisplayName("자동차 위치 클 경우 함수 테스트")
    void compareCarPositionAtBiggerTestFunction() {
        car.move(5);
        car.move(5);
        car.move(5);

        Car otherCar = new Car("otherCar");
        otherCar.move(5);
        otherCar.move(5);

        assertThat(car.compareTo(otherCar)).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 위치 작을 경우 함수 테스트")
    void compareCarPositionAtSmallerTestFunction() {
        car.move(5);

        Car otherCar = new Car("otherCar");
        otherCar.move(5);
        otherCar.move(5);

        assertThat(car.compareTo(otherCar)).isEqualTo(-1);
    }

    @Test
    @DisplayName("자동차 위치 동일한 경우 함수 테스트")
    void compareCarPositionAtSameTestFunction() {
        car.move(5);
        car.move(5);

        Car otherCar = new Car("otherCar");
        otherCar.move(5);
        otherCar.move(5);

        assertThat(car.compareTo(otherCar)).isEqualTo(0);
    }
}
