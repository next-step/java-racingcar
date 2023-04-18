package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Garage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GarageTest {
    @DisplayName("3단계 - 자동차 경주 - 차고 객체가 생성되는지 확인")
    @Test
    void create_car_factory() {
        Garage garage = new Garage();
        assertThat(garage.getNumberOfCars()).isEqualTo(0);
    }

    @DisplayName("3단계 - 자동차 경주 - 입력한 수만큼 자동차 객체가 생성되는지 확인")
    @Test
    void create_cars() {
        //given
        Garage garage = new Garage();
        int numberOfCars = 3;

        //when
        List<Car> createdCars = garage.createCars(3);

        //then
        assertThat(createdCars).hasSize(numberOfCars);
    }

}
