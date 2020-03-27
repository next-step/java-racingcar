package racinggame.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.car.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarsTest {

    @DisplayName("우승자 찾기")
    @Test
    public void winner() throws Exception {
        //given
        List<Car> cars = Arrays.asList(new Car("a", 1)
                , new Car("b", 2)
                , new Car("c", 3)
                , new Car("d", 4)
                , new Car("e", 4));
        RacingCars racingCars = new RacingCars(cars);

        //when
        List<String> winner = racingCars.findWinner();

        //then
        assertAll(
                () -> assertThat(winner.size()).isEqualTo(2),
                () -> assertThat(winner).isEqualTo(Arrays.asList("d", "e"))
        );
    }

}
