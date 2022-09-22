package racing_car.step4.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_car.step4.domain.Car;
import racing_car.step4.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

class CarDTOTest {
    
    @Test
    @DisplayName("차량의 포지션 정보 확인")
    void getPosition() {
        Car car = new Car(new Position(3));
        CarDTO carDTO = car.information();
        assertThat(carDTO.getPosition()).isEqualTo(3);
    }
}