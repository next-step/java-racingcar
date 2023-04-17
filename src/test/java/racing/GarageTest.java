package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GarageTest {
    @DisplayName("3단계 - 자동차 경주 - 차고 객체가 생성되는지 확인")
    @Test
    void create_car_factory() {
        Garage garage = new Garage();
        assertThat(garage.getNumberOfCars()).isEqualTo(0);
    }

}
