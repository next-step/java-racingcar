package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {

    @DisplayName("변환한 값이 0을 넣거나 음수가 들어가면 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"1,0"}, delimiter = ',')
    void carRacing_inputZeroOrNegative(int carCount, int moveCount) {
        assertThatThrownBy(() -> Racing.racing(carCount, moveCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값으로 0이나 음수를 넣을 수 없습니다.");
    }

    @DisplayName("자동차 수로 넣은 값으로 map size가 생성된다.")
    @ParameterizedTest
    @CsvSource(value = {"1,3,1", "3,5,3", "7,3,7"}, delimiter = ',')
    void carRacing_mapSize(int carCount, int moveCount, int expected) {
        assertThat(Racing.racing(carCount, moveCount)).hasSize(expected);
    }

    @DisplayName("random 값으로 만들어져서 마지막의 결과가 0이상 moveCount 이하가 되도록 한다.")
    @ParameterizedTest
    @CsvSource(value = {"4,15,15", "3,17,17", "2,20,20"}, delimiter = ',')
    void carRacingTest_moveCountResult(int carCount, int moveCount, int expected) {
        ArrayList<Car> cars = Racing.racing(carCount, moveCount);
        for (Car car : cars) {
            Integer position = car.getPosition();
            assertThat(position).isGreaterThan(0);
            assertThat(position).isLessThan(expected);
        }
    }
}
