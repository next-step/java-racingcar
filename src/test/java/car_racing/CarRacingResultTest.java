package car_racing;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingResultTest {

    @Test
    void createCarRacingResult_default() {
        // given
        CarRacingResult carRacingResult = new CarRacingResult();

        // when
        List<List<Integer>> result = carRacingResult.getRacingResult();

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void update() {
        // given
        List<Car> carList = new ArrayList<Car>() {{
            add(new Car(1));
            add(new Car(2));
            add(new Car(3));
            add(new Car(4));
            add(new Car(5));
            add(new Car(6));
        }};

        Cars cars = new Cars(carList);
        CarRacingResult carRacingResult = new CarRacingResult();

        // when
        carRacingResult.update(cars);
        List<List<Integer>> result = carRacingResult.getRacingResult();

        // then
        assertThat(result.get(0)).isEqualTo(Lists.newArrayList(1, 2, 3, 4, 5, 6));
    }

}