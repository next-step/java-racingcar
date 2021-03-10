package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.action.RandomMovable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"one","two","three","four"})
    @DisplayName("Car 객체 생성")
    public void makeCar(String carName) {
        assertThatCode(() -> new Car(carName))
                .doesNotThrowAnyException();
    }


    @Test
    @DisplayName("자동차 전진")
    public void moveCar() {
        Car car = new Car("one");
        car.move();
        assertEquals(1,car.getPoisition());
    }


}
