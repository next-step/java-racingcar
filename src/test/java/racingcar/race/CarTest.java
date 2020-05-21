package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final String DEFAULT_CAR_NAME = "벤츠";

    @DisplayName("drive 를 통해 position을 변경하면 정상적으로 변경되는 지 확인")
    @Test
    void drive() {
        Car car = Car.newInstance(DEFAULT_CAR_NAME);

        car.drive(5);
        int firstDrivePosition = car.getPosition();
        assertThat(firstDrivePosition).isEqualTo(5);

        car.drive(3);
        int secDrivePosition = car.getPosition();
        assertThat(secDrivePosition).isEqualTo(8);
    }

    @DisplayName("drive를 호출하지 않고, 최초 position 이 0 인지 확인")
    @Test
    void getFirstPosition() {
        Car car = Car.newInstance(DEFAULT_CAR_NAME);
        assertThat(car.getPosition()).isEqualTo(0);
    }


    @DisplayName("자동차의 이름이 정상적으로 출력되는지 확인")
    @Test
    void getCarName() {
        Car car = Car.newInstance(DEFAULT_CAR_NAME);

        String actualName = car.getName();

        assertThat(actualName).isEqualTo(DEFAULT_CAR_NAME);
    }
}