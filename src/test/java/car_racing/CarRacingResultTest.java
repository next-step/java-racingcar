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
        List<Cars> result = carRacingResult.getRacingResult();

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void update() {
        // given
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(3);
        Car car4 = new Car(4);
        Car car5 = new Car(5);
        Car car6 = new Car(6);


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
        List<Cars> result = carRacingResult.getRacingResult();

        // then
        assertThat(result.get(0)).isEqualTo(new Cars(Lists.newArrayList(
                car1,
                car2,
                car3,
                car4,
                car5,
                car6)));
    }

}