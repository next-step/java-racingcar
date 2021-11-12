package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author han
 */
class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = Car.create("test");
    }

    @ParameterizedTest(name = "전진")
    @CsvSource(value = {"4,1", "5,1", "6,1"})
    void forward(int input, int expected) {
        assertThat(car.getInstanceByForward(input).getStep()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "멈춤")
    @CsvSource(value = {"1,0", "2,0", "3,0"})
    void stop(int input, int expected) {
        assertThat(car.getInstanceByForward(input).getStep()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "Random value 를 통한 전진 테스트")
    @MethodSource("racing.NumberHelperTest#randomIntegerListProvider")
    void forwardsWithRandom(int random) {
        boolean isForward = random >= RacingConstant.FORWARD_STANDARD;
        assertThat(car.getInstanceByForward(random).getStep() == 1).isEqualTo(isForward);
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다")
    void throwExceptionHasWrongName() {
        assertThatThrownBy(() -> Car.create("This name Greater than 5")).isInstanceOf(IllegalArgumentException.class);
    }
}