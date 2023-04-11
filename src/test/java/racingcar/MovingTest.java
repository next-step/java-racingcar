package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.RandomNumberGenerator;

@DisplayName("움직임 테스트")
public class MovingTest {

    @DisplayName("랜덤 숫자 중 0부터 3까지는 false 반환하고 4이상은 ture 를 반환한다")
    @Test
    void 전진하는_조건_테스트() {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        int generateNumber = numberGenerator.generate();
        boolean result = numberGenerator.isMovable();
        if (generateNumber < 3) {
            Assertions.assertThat(result).isFalse();
        }
        Assertions.assertThat(result).isTrue();
    }
}
