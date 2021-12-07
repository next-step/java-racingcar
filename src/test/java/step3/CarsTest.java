package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    public Cars cars = new Cars();



    @Test
    @DisplayName("Cars 객체로 자동차 객체 생성이 정상적으로 되는지 확인")
    public void createCarsTest(){
         Game game = new Game(3);
        cars.createCars();
        assertThat(cars.getSize()).isEqualTo(3);
    }
}
