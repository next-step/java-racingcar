package car_racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingResultTest {

    @Test
    void createCarRacingResult() {
        // given
        CarRacingResult carRacingResult = new CarRacingResult();

        // when
        String result = carRacingResult.show();

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void update() {
        // given
        List<Car> carList = new ArrayList<Car>(){{
            add(new Car(0, Status.MOVE));
            add(new Car(1, Status.MOVE));
            add(new Car(2, Status.STOP));
            add(new Car(3, Status.MOVE));
            add(new Car(4, Status.STOP));
            add(new Car(5, Status.MOVE));
        }};

        Cars cars = new Cars(carList);
        CarRacingResult carRacingResult = new CarRacingResult();

        // when
        carRacingResult.update(cars);
        String result = carRacingResult.show();

        // then
        assertThat(result).isEqualTo("-\n-\n\n-\n\n-\n\n");
    }

    @Test
    @DisplayName("There is null passed, returns empty result")
    void update_with_null_cars() {
        // given
        CarRacingResult carRacingResult = new CarRacingResult();
        carRacingResult.update(null);

        // when
        String result = carRacingResult.show();

        // then
        assertThat(result).isEmpty();
    }
}