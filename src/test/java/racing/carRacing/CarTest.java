package racing.carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 8, 9})
    @DisplayName("이동 테스트")
    void runMoveTest(int input) {
        Car car = new Car("");
        int condition = 4;
        MovementStrategy strategy = new ManualMovement(input, condition);

        car.run(strategy);

        assertThat(car).usingRecursiveComparison()
                .isEqualTo(new Car("-"));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("중지 테스트")
    void runStopTest(int input) {
        Car car = new Car("");
        int condition = 4;
        MovementStrategy strategy = new ManualMovement(input, condition);

        car.run(strategy);

        assertThat(car).usingRecursiveComparison()
                .isEqualTo(new Car(""));
    }

}
