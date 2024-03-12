package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.application.RacingCarService;
import racingcar.domain.Car;
import racingcar.domain.MoveCommand;
import racingcar.utils.TestNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarServiceTest {

    @ParameterizedTest
    @DisplayName("N 대의 차량을 M 번 움직였을 경우 테스트")
    @CsvSource(value = {"0:0","1:0","2:0","3:0","4:2","5:2","6:2","7:2","8:2","9:2"}, delimiter = ':')
    void testMoveCar(int number, int expectedPosition) {
        int countCar = 2;
        int repeatCount = 2;

        RacingCarService racingCarService = new RacingCarService(new MoveCommand(new TestNumber(number)));
        racingCarService.initCars(countCar);

        for (int i = 0; i < repeatCount; i++) {
            racingCarService.moveCar();
        }

        assertThat(racingCarService.cars()).hasSize(countCar);
        for (Car car : racingCarService.cars()) {
            assertThat(car.getPosition()).isEqualTo(expectedPosition);
        }
    }

    @Test
    @DisplayName("N 대의 차량을 만들기 전에, 이동하면 예외 발생")
    void testMoveCarBeforeMakeCars() {
        RacingCarService racingCarService = new RacingCarService(new MoveCommand(new TestNumber(0)));
        assertThatThrownBy(racingCarService::moveCar).isInstanceOf(RuntimeException.class);
    }
}
