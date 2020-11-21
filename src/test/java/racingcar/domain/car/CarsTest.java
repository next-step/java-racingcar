package racingcar.domain.car;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("우승자를 가려낸다")
    void should_return_winners() {
        //Given
        List<Car> givenCars = Lists.newArrayList(
                new Car("damas", 4),
                new Car("bmw", 4),
                new Car("benz", 2)
        );
        Cars cars = new Cars(givenCars);

        //When
        List<String> strings = cars.filterWinners();

        //Then
        assertThat(strings).containsAll(Lists.newArrayList("damas", "bmw"));

    }

}
