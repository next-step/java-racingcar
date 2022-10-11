package carracing;

import calculator.Positive;
import carracing.domain.Car;
import carracing.domain.Cars;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    void 쉼표를_통해_자동차를_생성() {
        String[] strings = {"AA","BB"};
        Cars cars = Cars.makeCars(strings);
        assertThat(cars.getCarsSize()).isEqualTo(2);
    }

    @Test
    void 자동차주인이름_설정_가능(){

        String[] strings = {"AA","BB"};
        Cars cars = Cars.makeCars(strings);

        List<Car> carsList = new LinkedList<>();
        for (String string : strings) {
            carsList.add(new Car(string));
        }

        assertThat(cars.getCars()).isEqualTo(carsList);
    }
}
