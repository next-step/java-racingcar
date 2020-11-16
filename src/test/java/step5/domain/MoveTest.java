package step5.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step5.domain.racing.Cars;
import step5.domain.racing.cars.Car;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created By mand2 on 2020-11-12.
 */
public class MoveTest {

    Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.of("pink,green,white,blue");
    }

    @ParameterizedTest
    @DisplayName("랜덤값에 따라 움직이는가-아예 움직이지 않는다")
    @ValueSource(ints = {2,3,4,5})
    void car_immovable_randomly(int input) {

        // given
        for (Car car : cars.getCars()) {
            car.forward(input);
        }

        // when
        cars.runRound(() -> 0);

        // then
        for (Car car : cars.getCars()) {
            assertThat(car.getStep()).isEqualTo(input);
        }
    }

    @ParameterizedTest
    @DisplayName("랜덤값에 따라 움직이는가-계속 움직인다")
    @ValueSource(ints = {2,3,4,5})
    void car_movable_randomly(int input) {

        // given
        for (Car car : cars.getCars()) {
            car.forward(input);
        }

        // when
        cars.runRound(() -> 1);

        // then
        for (Car car : cars.getCars()) {
            assertThat(car.getStep()).isEqualTo(input + 1);
        }
    }


}
