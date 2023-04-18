package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GarageTest {
    @DisplayName("3단계 - 자동차 경주 - 차고 객체가 생성되는지 확인")
    @Test
    void create_car_factory() {
        Garage garage = new Garage();
        assertThat(garage.getNumberOfCars()).isEqualTo(0);
    }

    @DisplayName("3단계 - 자동차 경주 - 입력한 자동차 이름 수 만큼 자동차 객체가 생성되는지 확인")
    @Test
    void create_cars() {
        //given
        Garage garage = new Garage();

        //when;
        List<Car> createdCars = garage.createCars("kgh,test1,test2");

        //then
        assertThat(createdCars).hasSize(3);
    }

}
