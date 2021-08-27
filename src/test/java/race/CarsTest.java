package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.createCars(new ArrayList<Car>());
    }

    @Test
    @DisplayName("createCarList 테스트")
    void createCarListTest() {
        //then
        assertThat(cars.getCars().size()).isEqualTo(0);
    }

    @Test
    @DisplayName("Collection unmodifiableMap 테스트")
    void unmodifiableListTest() {
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> {
            cars.getCars().add(new Car());
        });
    }

}