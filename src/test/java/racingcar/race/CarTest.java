package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("drive 를 통해 position을 변경하면 정상적으로 변경되는 지 확인")
    @Test
    void drive() {
        Car car = new Car();
        car.drive(5);
        int firstDrivePosition = car.getPosition();
        car.drive(3);
        int secDrivePosition = car.getPosition();

        assertThat(firstDrivePosition).isEqualTo(5);
        assertThat(secDrivePosition).isEqualTo(8);

    }

    @DisplayName("drive를 호출하지 않고, 최초 position 이 0 인지 확인")
    @Test
    void getFirstdPosition() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
    }
}