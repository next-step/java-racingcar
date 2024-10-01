package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarMoveTest {

    @Test
    @DisplayName("랜덤 값이 4 미만일 때 자동차가 이동하지 않음")
    void shouldNotMove() {
        MoveStrategy neverMoveStrategy = () -> false;
        RacingCar car = new RacingCar("TestCar", neverMoveStrategy);
        int initialPosition = car.getPosition();

        car.move();

        assertThat(car.getPosition()).isEqualTo(initialPosition);
    }

    @Test
    @DisplayName("랜덤 값이 4 이상일 때 자동차가 전진함")
    void shouldMove() {
        MoveStrategy alwaysMoveStrategy = () -> true;
        RacingCar car = new RacingCar("TestCar", alwaysMoveStrategy);
        int initialPosition = car.getPosition();

        car.move();

        assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
    }

    @ParameterizedTest
    @DisplayName("여러 번의 이동 시도 후 자동차 위치 확인")
    @CsvSource({
            "0, 0",
            "1, 1",
            "5, 5",
            "10, 10"
    })
    void moveMultipleTimes(int moveAttempts, int expectedPosition) {
        MoveStrategy alwaysMoveStrategy = () -> true;
        RacingCar car = new RacingCar("TestCar", alwaysMoveStrategy);

        for (int i = 0; i < moveAttempts; i++) {
            car.move();
        }

        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}