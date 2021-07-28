package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
public class ValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    void 자동차_대수_10이하의_자연수가_아닐경우_오류_발생(int carCount) {
        assertThatIllegalArgumentException().isThrownBy(() -> Validator.validateCarCount(carCount))
                .withMessageContaining("자동차 대수는 10이하의 자연수만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    void 자동차_대수_10이하의_자연수일경우_오류_미발생(int carCount) {
        assertDoesNotThrow(() -> Validator.validateCarCount(carCount));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    void 이동횟수_10이하의_자연수가_아닐경우_오류_발생(int moveCount) {
        assertThatIllegalArgumentException().isThrownBy(() -> Validator.validateMoveCount(moveCount))
                .withMessageContaining("이동 횟수는 10이하의 자연수만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    void 이동횟수_10이하의_자연수일경우_오류_미발생(int moveCount) {
        assertDoesNotThrow(() -> Validator.validateMoveCount(moveCount));
    }


}
