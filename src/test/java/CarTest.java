import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    //TODO: 조건 관련 부분이 CarMoveCondition 이동하여 CarMoveCondition 을 테스트해야함
    /*@ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void carMoveTest(int given, int expected) {
        Car car = new Car();
        car.move(given);

        assertThat(car.currentPosition).isEqualTo(expected);
    }

    @Test
    void carMoveFailedTest() {
        assertThatThrownBy(() -> new Car().move())
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("not available value");
    }*/
}
