package race.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.domain.Car;
import race.domain.Cars;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        List<String> carNames = new ArrayList<>();
        carNames.add("test1");
        carNames.add("test2");
        cars = Cars.createCars(carNames);
    }

    @Test
    @DisplayName("Cars_정적팩토리_메서드_테스트")
    void Cars_정적팩토리_메서드_테스트() {
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