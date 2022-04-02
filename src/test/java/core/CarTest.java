package core;

import core.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 MAX_CAR_NAME_LENGTH 초과면 false 를 반환한다")
    void isValidTooLong() {
        //given
        char[] array = new char[Car.MAX_CAR_NAME_LENGTH + 1];
        Arrays.fill(array, 'a');
        String carName = new String(array);
        Car car = new Car(carName);

        //when
        boolean result = car.isValid();

        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("자동차 이름이 MAX_CAR_NAME_LENGTH 이하면 true 를 반환한다")
    void isValid() {
        //given
        char[] array = new char[Car.MAX_CAR_NAME_LENGTH];
        Arrays.fill(array, 'a');
        String carName = new String(array);
        Car car = new Car(carName);

        //when
        boolean result = car.isValid();

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("랜덤값이 BASE_MOVE_VALUE 미만이면 움직이지 않는다")
    void stopMoveForSmallInt() {
        //given
        Car car = new Car("a");
        int initialPosition = car.getPosition();

        //when
        car.move(Car.BASE_MOVE_VALUE - 1);
        int afterPosition = car.getPosition();


        //then
        assertThat(afterPosition).isEqualTo(initialPosition);
    }

    @Test
    @DisplayName("랜덤값이 BASE_MOVE_VALUE 이상이면 움직인다")
    void moveForBigInt() {
        //given
        Car car = new Car("a");
        int initialPosition = car.getPosition();

        //when
        car.move(Car.BASE_MOVE_VALUE);
        int afterPosition = car.getPosition();

        //then
        assertThat(afterPosition).isEqualTo(initialPosition + 1);
    }

    @Test
    @DisplayName("positionHistory 의 tail 과 position 은 같다")
    void positionHistoryIsSameWithPosition() {
        //given
        Car car = TestObjectGenerator.generateCar("a", 5);

        //when
        car.move(Car.BASE_MOVE_VALUE);
        int position = car.getPosition();
        int positionHistoryTail = car.getPositionHistory().get(car.getPositionHistory().size() - 1);

        //then
        assertThat(positionHistoryTail).isEqualTo(position);
    }
}