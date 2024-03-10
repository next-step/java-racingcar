package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.application.RacingCarService;
import racingcar.domain.Car;
import racingcar.infra.MoveCommandImpl;
import racingcar.utils.TestNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarServiceTest {

    @ParameterizedTest
    @CsvSource(value = {"0:0","1:0","2:0","3:0","4:1","5:1","6:1","7:1","8:1","9:1"}, delimiter = ':')
    void testMoveCar(int number, int expectedPosition) {
        RacingCarService racingCarService = new RacingCarService(new MoveCommandImpl(new TestNumber(number)));
        Car car  = new Car();
        racingCarService.moveCar(car);

        assertThat(car.position()).isEqualTo(expectedPosition);
    }
}
