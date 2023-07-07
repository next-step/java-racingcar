package car.ui;

import static org.assertj.core.api.Assertions.assertThat;

import car.domain.Car;
import car.domain.CarsFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultCarsFormatterTest {

    final DefaultCarsFormatter formatter = new DefaultCarsFormatter();

    @Test
    @DisplayName("Car 객체를 받아서 자동차 이름과 주행 거리를 표시한다.")
    void formatSingleCar() {
        Car car = new Car(5, "pobi");
        assertThat(formatter.formatSingleCar(car)).isEqualTo("pobi : -----");
    }
}