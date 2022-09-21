package racing_car.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing_car.step3.dto.CarDTO;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private List<Car> carsList;
    
    @BeforeEach
    void setUp() {
        carsList = Arrays.asList(new Car(0), new Car(0), new Car(0));
    }
    
    @Test
    @DisplayName("차량 객체 생성 대수")
    void createCars() {
        assertThat(new Cars(carsList)).isEqualTo(new Cars(CarsFactory.from(3)));
    }
    
    @DisplayName("차량들의 정보(CarDTO) 확인")
    @ParameterizedTest(name = "{displayName} : index = {0}, position : {1}")
    @CsvSource(value = {"0:4", "1:5", "2:2"}, delimiter = ':')
    void carInfo(int idx, int position) {
        List<Car> carsList = Arrays.asList(new Car(4), new Car(5), new Car(2));
        List<CarDTO> carDTOS = new Cars(carsList).information();
        assertThat(carDTOS.get(idx).getPosition()).isEqualTo(position);
    }
    
    @Test
    @DisplayName("차량 이동 여부 확인")
    void move() {
        Cars cars = new Cars(carsList);
        List<Car> tmpCarsList = Arrays.asList(new Car(2), new Car(2), new Car(2));
        
        cars.move(() -> true);
        cars.move(() -> true);
        
        assertThat(cars).isEqualTo(new Cars(tmpCarsList));
    }
}