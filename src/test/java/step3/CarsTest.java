package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("Cars 객체로 자동차 객체 생성이 정상적으로 되는지 확인")
    public void createCarsTest(){
        Cars cars = new Cars(3);
        Game game = new Game(3);
        assertThat(cars.getSize()).isEqualTo(3);
    }
}
