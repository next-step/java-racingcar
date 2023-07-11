package car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import car.domain.model.Car;
import car.domain.model.CarName;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 이름 입력이 정상적인지 확인")
    void carNameValid() {
        String expectedCarName = "pobi";

        CarName carName = new CarName(expectedCarName);

        assertThat(carName).extracting("name").isEqualTo(expectedCarName);
    }

    @Test
    @DisplayName("자동차 이름 길이가 5보다 길 경우")
    void carNameInvalid() {
        String expectedCarName = "pobiii";

        assertThrows(IllegalArgumentException.class, () -> new CarName(expectedCarName));
    }

    @Disabled
    @Test
    @DisplayName("단일 자동차 전진 테스트")
    void carMoveSuccess() {
        String carName = "a";

        Car car = new Car(carName);

        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
        car.move(9);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Disabled
    @Test
    @DisplayName("단일 자동차 멈춤 테스트")
    void carStop() {
        String carName = "abcde";

        Car car = new Car(carName);

        car.move(0);
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
