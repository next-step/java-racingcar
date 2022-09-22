package racing_car.step3.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_car.step3.domain.Car;
import racing_car.step3.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarDTOTest {
    
    @Test
    @DisplayName("차량의 포지션 정보 확인")
    void getPosition() {
        Car car = new Car(new Position(3));
        CarDTO carDTO = car.information();
        assertThat(carDTO.getPosition()).isEqualTo(new Position(3));
    }
}