package step5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.domain.Car;
import step5.domain.CarEngine;

import static org.assertj.core.api.Java6Assertions.assertThat;

class CarTest {

    @CsvSource(value = {"pobi:4:1", "pobi:2:0"}, delimiter = ':')
    @ParameterizedTest(name = "주어진_숫자가_{1}RPM이면_자동차의_moveCount는_{2}이_된다")
    void 주어진_숫자가_4RPM이상이면_자동차의_moveCount는_1증가한다(String carName, int givenRpm, int givenMoveCount) {
        Car car = new Car(carName, new CarEngine(), new SpeedMovingStrategyTest(givenRpm));
        car.move();

        assertThat(car.getMovedCount()).isEqualTo(givenMoveCount);
    }

}
