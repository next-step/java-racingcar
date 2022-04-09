package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.AnnouncementPrinter;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차 이름이 MAX_CAR_NAME_LENGTH 이하면 입력받은 이름을 갖고 위치가 0인 Car 를 반환한다")
    void create() {
        //given
        char[] array = new char[Car.MAX_CAR_NAME_LENGTH];
        Arrays.fill(array, 'a');
        CarName carName = CarName.create(new String(array));

        //when
        Car result = Car.create(carName);

        //then
        assertThat(result.getCarName()).isEqualTo(carName);
        assertThat(result.getPosition()).isEqualTo(0);
        assertThat(result.getPositionHistory()).isEmpty();
    }

    @Test
    @DisplayName("랜덤값이 BASE_MOVE_VALUE 미만이면 움직이지 않는다")
    void stopMoveForSmallInt() {
        //given
        CarName carName = CarName.create("a");
        Car car = Car.create(carName);
        int initialPosition = car.getPosition();

        //when
        Car movedCar = car.move(Car.BASE_MOVE_VALUE - 1);
        int afterPosition = movedCar.getPosition();


        //then
        assertThat(afterPosition).isEqualTo(initialPosition);
    }

    @Test
    @DisplayName("랜덤값이 BASE_MOVE_VALUE 이상이면 움직인다")
    void moveForBigInt() {
        //given
        CarName carName = CarName.create("a");
        Car car = Car.create(carName);
        int initialPosition = car.getPosition();

        //when
        Car movedCar = car.move(Car.BASE_MOVE_VALUE);
        int afterPosition = movedCar.getPosition();

        //then
        assertThat(afterPosition).isEqualTo(initialPosition + 1);
    }

    @Test
    @DisplayName("positionHistory 의 tail 과 position 은 같다")
    void positionHistoryIsSameWithPosition() {
        //given
        Car car = TestObjectGenerator.generateCar("a", 5);

        //when
        Car movedCar = car.move(Car.BASE_MOVE_VALUE);
        int position = movedCar.getPosition();
        int positionHistoryTail = movedCar.getPositionHistory().get(movedCar.getPositionHistory().size() - 1);

        //then
        assertThat(positionHistoryTail).isEqualTo(position);
    }
}