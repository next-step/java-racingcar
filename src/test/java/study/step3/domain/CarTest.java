package study.step3.domain;

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
        Car car = new Car();
        int expectedPosition = 0;

        // when

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @ParameterizedTest(name = "차량 전진 테스트 | {arguments}")
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    public void moveForward(int randomNumber, int expectedPosition) {
        // given
        Car car = new Car();

        // when
        car.moveForwardIfNumberValid(randomNumber);

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}
