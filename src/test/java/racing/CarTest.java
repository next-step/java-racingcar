package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName(value = "전진 테스트")
    void forwards() {
        assertThat(car.forward(0)).isEqualTo(0);
        assertThat(car.forward(1)).isEqualTo(0);
        assertThat(car.forward(10)).isEqualTo(1);
    }

    @ParameterizedTest(name = "Random value 를 통한 전진 테스트")
    @MethodSource("racing.NumberHelperTest#randomIntegerListProvider")
    void forwardsWithRandom(int random) {
        boolean isForward = random > 4;
        assertThat(car.forward(random) == 1).isEqualTo(isForward);
    }
}