package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {

    private static final int TEST_CAR_MOVE_STEP = 1;
    private static final String RANKED_STRING_DELIMITER = ",";

    // init
    @DisplayName("init Class")
    @ParameterizedTest
    @CsvSource(value = {"carName:0", "name:6"}, delimiter = ':')
    public void testClassInitialize(String carName, int location) {

        Cars cars = Cars.of(carName.split(""), location, () -> TEST_CAR_MOVE_STEP);
        assertThat(cars.getCarsList().size()).isEqualTo(carName.split("").length);
        assertThat(cars.getCarsList().stream().filter(car -> car.getLocation() == location).count()).isEqualTo(carName.split("").length);

    }

    // init with error
    @DisplayName("init Class")
    @ParameterizedTest
    @CsvSource(value = {"name:-1"}, delimiter = ':')
    public void testClassInitializeWithError(String carName, int location) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                Cars.of(carName.split(""), location, () -> TEST_CAR_MOVE_STEP)
        );
    }


    // init
    @DisplayName("winner test")
    @ParameterizedTest
    @CsvSource(value = {"winner,looser:0"}, delimiter = ':')
    public void testWinner(String carName, int location) {

        // ready
        Cars cars = Cars.of(carName.split(RANKED_STRING_DELIMITER), location, () -> TEST_CAR_MOVE_STEP);

        cars.move();
        cars.getCarsList().get(0).move();
        System.out.println(cars.getWinners());

        assertThat(cars.getWinners().contains("winner")).isTrue();

    }

}
