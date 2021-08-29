package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        String[] carNames = new String[]{"testCar1", "testCar2"};
        cars = Cars.createCars(carNames, new ArrayList<Car>());
    }

    @Test
    @DisplayName("createCarList 테스트")
    void createCarListTest() {
        //then
        assertThat(cars.getCars().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Collection unmodifiableMap 테스트")
    void unmodifiableListTest() {
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> {
            cars.getCars().add(new Car());
        });
    }

}