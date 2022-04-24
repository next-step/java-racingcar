package racingversion2.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("우승자 자동차를 찾는다.")
    void findWinners(){
        Car jaden = new Car("jaden", 3);
        Car bmw = new Car("bmw", 1);
        Car benz = new Car("benz", 3);

        Cars cars = new Cars(List.of(jaden, bmw, benz));
        List<Car> winners = cars.findWinners();
        assertThat(winners).doesNotContain(bmw);
        assertThat(winners).contains(jaden, benz);
    }


}