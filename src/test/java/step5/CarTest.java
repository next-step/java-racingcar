package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step5.dto.Car;
import step5.dto.CarName;
import step5.dto.Position;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"poby", "dy", "kero", "next"})
    @DisplayName("자동차 생성시 기본 위치는 0이다")
    public void defaultPosition(String carName) {
        Car car = new Car(new CarName(carName));

        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }

}
