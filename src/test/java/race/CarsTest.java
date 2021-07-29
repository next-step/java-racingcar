package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.model.Car;
import racing.model.Cars;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {

    Cars cars = new Cars();

    @BeforeEach
    void setting() {
        cars.prepareCars(new String[]{"test1","test2","test3"});
        for (Car car : cars.carList()) {
            car.forward();
        }
    }

    @ParameterizedTest
    @DisplayName("cars name test")
    @CsvSource(value = {"test1:true", "test2:true", "test3:true", "test4:false"}, delimiter = ':')
    void carsNameTest(String name, boolean expected) {
        List<String> carNameList = cars.carList()
                .stream()
                .map(car -> car.carName())
                .collect(Collectors.toList());
        assertEquals(carNameList.contains(name), expected);
    }

    @Test
    @DisplayName("cars max Distance Test")
    void carsMaxDistanceTest() {
        assertThat(cars.getMaxDistance()).isEqualTo(1);
    }
}
