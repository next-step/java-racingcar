package racing_car.step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing_car.step3.domain.Car;
import racing_car.step3.domain.Cars;
import racing_car.step3.domain.CarsFactory;
import racing_car.step3.domain.Position;
import racing_car.step3.dto.CarDTO;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private List<racing_car.step3.domain.Car> carsList;
    
    @BeforeEach
    void setUp() {
        racing_car.step3.domain.Position zeroPosition = new racing_car.step3.domain.Position(0);
        carsList = Arrays.asList(new racing_car.step3.domain.Car(zeroPosition), new racing_car.step3.domain.Car(zeroPosition), new racing_car.step3.domain.Car(zeroPosition));
    }
    
    @Test
    @DisplayName("차량 객체 생성 대수")
    void createCars() {
        assertThat(new racing_car.step3.domain.Cars(carsList)).isEqualTo(new racing_car.step3.domain.Cars(CarsFactory.from(3)));
    }
    
    @DisplayName("차량들의 정보(CarDTO) 확인")
    @ParameterizedTest(name = "{displayName} : index = {0}, position : {1}")
    @CsvSource(value = {"0:4", "1:5", "2:2"}, delimiter = ':')
    void carInfo(int idx, int position) {
        List<racing_car.step3.domain.Car> carsList = Arrays.asList(new racing_car.step3.domain.Car(new racing_car.step3.domain.Position(4)), new racing_car.step3.domain.Car(new racing_car.step3.domain.Position(5)), new racing_car.step3.domain.Car(new racing_car.step3.domain.Position(2)));
        List<CarDTO> carDTOS = new racing_car.step3.domain.Cars(carsList).information();
        assertThat(carDTOS.get(idx).getPosition()).isEqualTo(position);
    }
    
    @Test
    @DisplayName("차량 이동 여부 확인")
    void moveTry() {
        racing_car.step3.domain.Cars cars = new racing_car.step3.domain.Cars(carsList);
        racing_car.step3.domain.Position twoPosition = new Position(2);
        List<racing_car.step3.domain.Car> tmpCarsList = Arrays.asList(new racing_car.step3.domain.Car(twoPosition), new racing_car.step3.domain.Car(twoPosition), new Car(twoPosition));
        
        cars = new racing_car.step3.domain.Cars(cars.moveTry(() -> true));
        cars = new racing_car.step3.domain.Cars(cars.moveTry(() -> true));
        
        assertThat(cars).isEqualTo(new Cars(tmpCarsList));
    }
}