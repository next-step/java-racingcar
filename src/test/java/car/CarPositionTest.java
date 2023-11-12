package car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarPositionTest {

    @ParameterizedTest
    @CsvSource(value= {"0:0", "1:1", "2:2", "3:3"}, delimiter = ':')
    public void 거리가_양수_혹은_0일_때_정상_동작_테스트(Integer distance, Integer expected) {
        CarPosition carPosition = new CarPosition(distance);

        assertThat(carPosition.getDistance()).isEqualTo(expected);
    }

    @Test
    public void 거리가_음수일_때_에러_테스트() {
        assertThatThrownBy(() -> new CarPosition(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
