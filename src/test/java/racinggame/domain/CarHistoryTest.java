package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarHistoryTest {

    @DisplayName("각 Car 와 CarHistory 이름 일치여부 확인")
    @Test
    public void getCarHistoryNameTest() {
        Car car = new Car("a", 7);
        CarHistory carHistory = new CarHistory(car);
        Assertions.assertThat(carHistory.getCarName()).isEqualTo(car.getCarName());
    }

    @DisplayName("각 Car 와 CarHistory 이름 일치여부 확인")
    @Test
    public void getLocation() {
        Car car = new Car("a", 7);
        CarHistory carHistory = new CarHistory(car);
        Assertions.assertThat(carHistory.getLocation()).isEqualTo(car.getLocation());
    }


}
