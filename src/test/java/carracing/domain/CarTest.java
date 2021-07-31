package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("차량 생성 테스트")
    public void createCar() {
        // given
        CarName carName = new CarName("iiaii");
        Car car = new Car(carName);
        String expectedName = "iiaii";
        int expectedPosition = 1;

        // when

        // then
        assertThat(car.getCarStatus().getName()).isEqualTo(expectedName);
        assertThat(car.getCarStatus().getPosition()).isEqualTo(expectedPosition);
    }

    @ParameterizedTest(name = "차량 전진 테스트 | {arguments}")
    @CsvSource(value = {"0:1", "1:1", "2:1", "3:1", "4:2", "5:2", "6:2", "7:2", "8:2", "9:2"}, delimiter = ':')
    public void moveForward(int randomNumber, int expectedPosition) {
        // given
        CarName carName = new CarName("iiaii");
        Car car = new Car(carName);

        // when
        car.moveForwardIfNumberValid(randomNumber);

        // then
        assertThat(car.getCarStatus().getPosition()).isEqualTo(expectedPosition);
    }
}
