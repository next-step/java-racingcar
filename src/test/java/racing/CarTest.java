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
        assertThat(car.getInstanceByForward(0).getStep()).isEqualTo(0);
        assertThat(car.getInstanceByForward(1).getStep()).isEqualTo(0);
        assertThat(car.getInstanceByForward(10).getStep()).isEqualTo(1);
    }

    @ParameterizedTest(name = "Random value 를 통한 전진 테스트")
    @MethodSource("racing.NumberHelperTest#randomIntegerListProvider")
    void forwardsWithRandom(int random) {
        boolean isForward = random > 4;
        assertThat(car.getInstanceByForward(random).getStep() == 1).isEqualTo(isForward);
    }
}