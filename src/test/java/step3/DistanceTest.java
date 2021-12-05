package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class DistanceTest {
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 2", "3, 4"})
    @DisplayName("distance가 정상적으로 증가하는지 테스트 합니다.")
    void move(int initialValue, int movedValue) {
        Distance distance = new Distance(initialValue);
        assertThat(distance.move()).isEqualTo(new Distance(movedValue));
    }
}
