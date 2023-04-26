package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("일급컬렉션 Cars에 car 개수 체크")
    void check_car_number(){
        Cars car = new Cars();
        car.setCarNumber(5);

        assertThat(car.getCar().size()).isEqualTo(5);
    }


    @Test
    @DisplayName("New car 추가")
    void add_new_car(){
        Cars car = new Cars();
        car.addCar("test");

        assertThat(car.getCar().size()).isEqualTo(1);
    }
}
