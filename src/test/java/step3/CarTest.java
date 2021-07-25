package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Java6Assertions.assertThat;

class CarTest {

    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
    @ParameterizedTest(name = "주어진_숫자가_{0}RPM이면_자동차의_moveCount는_{1}이_된다")
    void 주어진_숫자가_특정RPM이상이면_자동차의_moveCount는_증가한다(int givenRpm, int givenMoveCount) {
        Car car = new Car(new CarEngine());
        car.move(givenRpm);

        assertThat(car.getMovedCount()).isEqualTo(givenMoveCount);
    }

}
