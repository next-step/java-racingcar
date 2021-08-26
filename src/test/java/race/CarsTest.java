package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.createCarMap(3);
    }

    @Test
    @DisplayName("createCarList 테스트")
    void createCarListTest() {
        //then
        assertThat(cars.getCarMap().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Collection unmodifiableMap 테스트")
    void unmodifiableListTest() {
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> {
            cars.getCarMap().put("test", new Car());
        });
    }

}