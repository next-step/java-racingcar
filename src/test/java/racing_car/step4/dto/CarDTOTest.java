package racing_car.step4.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_car.step4.domain.Car;
import racing_car.step4.domain.CarName;
import racing_car.step4.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

class CarDTOTest {
    private CarDTO carDTO;
    
    @BeforeEach
    void setUp() {
        Car car = new Car(new CarName("jun"), new Position(3));
        carDTO = car.information();
    }
    
    @Test
    @DisplayName("차량의 포지션 정보 확인")
    void getPosition() {
        assertThat(carDTO.getPosition()).isEqualTo(3);
    }
    
    @Test
    @DisplayName("차량의 이름 정보 확인")
    void getCarName() {
        assertThat(carDTO.getCarName()).isEqualTo("jun");
    }
}