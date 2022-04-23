package racingversion2.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("우승자가 되기위한 위치를 찾는다.")
    void findWinningPosition(){
        Cars cars = new Cars(List.of(new Car("jaden", 0),
            new Car("bmw", 1),
            new Car("benz", 3)));

        assertThat(cars.winningPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("우승자 자동차를 찾는다.")
    void findWinners(){
        Car jaden = new Car("jaden", 3);
        Car bmw = new Car("bmw", 1);
        Car benz = new Car("benz", 3);

        Cars cars = new Cars(List.of(jaden, bmw, benz));

        List<Car> winners = cars.findWinners(cars.winningPosition());
        assertThat(winners).doesNotContain(bmw);
        assertThat(winners).contains(jaden, benz);
    }


}