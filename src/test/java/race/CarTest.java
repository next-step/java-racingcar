package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    private static final int DEFAULT_TRY_COUNT = 5;
    private static final String DEFAULT_NAMES = "pobi";
    private static final int FIRST_LOCATION = 1;

    @DisplayName("라운드까지의 이동거리값 반환")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:0"}, delimiter = ':')
    void getDistance(int round, int expected) {
        Car car = Car.of(DEFAULT_TRY_COUNT, DEFAULT_NAMES);
        car.move();
        assertThat(car.getDistance(round)).isGreaterThanOrEqualTo(expected);
    }

    @DisplayName("시도할 회수만큼 자동차 이동(전진 또는 멈춤)되었는지 확인")
    @Test
    void move() {
        Car car = Car.of(DEFAULT_TRY_COUNT, DEFAULT_NAMES);
        car.move();
        assertThat(car.getDistance().size()-FIRST_LOCATION).isEqualTo(DEFAULT_TRY_COUNT);
    }

}