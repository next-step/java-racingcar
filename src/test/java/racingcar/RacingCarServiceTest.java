package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.application.RacingCarService;
import racingcar.domain.Car;
import racingcar.domain.MoveType;
import racingcar.infra.MoveCommandImpl;
import racingcar.utils.TestNumber;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarServiceTest {

    @ParameterizedTest
    @CsvSource(value = {"0:0","1:0","2:0","3:0","4:2","5:2","6:2","7:2","8:2","9:2"}, delimiter = ':')
    void testMoveCar(int number, int expectedPosition) {
        int countCar = 2;
        int repeatCount = 2;

        RacingCarService racingCarService = new RacingCarService(new MoveCommandImpl(new TestNumber(number)), countCar);
        racingCarService.repeatMoveCar(repeatCount);

        assertThat(racingCarService.cars()).hasSize(countCar);
        for (Car car : racingCarService.cars()) {
            assertThat(car.position()).isEqualTo(expectedPosition);
        }
    }
}
