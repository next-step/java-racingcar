package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car car = new Car();

    @Test
    @DisplayName("차의 개수 확인")
    void inputGameInfo() {
        car.inputGameInfo("3", 7);
        assertThat(car.carInfo.length).isEqualTo(3);
    }
}
