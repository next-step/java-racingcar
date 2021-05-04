package racing.infra;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RandomNumberTest {
    private RandomNumber randomNumber;

    @DisplayName("1~9 범위 외 숫자 생성 시 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index} {displayName} input value={0}")
    @ValueSource(ints = {0, -5, 10, 15})
    void case_when_randomNumber_create_throws_illegalArgumentException(int randomNumber) {
        assertThrows(IllegalArgumentException.class, () -> RandomNumber.of(randomNumber));
    }

    @DisplayName("1~9 범위 내 숫자 생성 시 정상 생성")
    @ParameterizedTest(name = "{index} {displayName} input value={0}")
    @ValueSource(ints = {1, 3, 9})
    void case_when_randomNumber_range_under_1_to_9(int randomNumber) {
        assertDoesNotThrow(() -> RandomNumber.of(randomNumber));
    }

    @DisplayName("4 이상 RandomNumber일 경우 isGreaterThanOrEqualTo 메소드 true 리턴")
    @ParameterizedTest(name = "{index} {displayName} input value={0}")
    @ValueSource(ints = {4, 6, 9})
    void case_when_randomNumber_greater_than_or_equal_to_4(int randomNumber) {
        final int MOVABLE_NUMBER = 4;
        assertThat(RandomNumber.of(randomNumber).isGreaterThanOrEqualTo(MOVABLE_NUMBER));
    }
}
