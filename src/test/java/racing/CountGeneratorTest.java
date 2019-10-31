package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CountGeneratorTest {

    @Test
    @DisplayName("bound값을 1보다 작은 값을 넘겼을때 IllegalArgumentException이 나는지 확인한다.")
    void getRandomInt() {
        int expectBound = 0;
        assertThatThrownBy(() -> CountGenerator.getRandomInt(expectBound))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
