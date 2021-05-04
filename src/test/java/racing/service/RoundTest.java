package racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.infra.RandomNumber;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoundTest {
    private RandomNumber randomNumber;

    @DisplayName("1보다 작은 숫자의 라운드 생성 시 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index} {displayName} input value={0}")
    @ValueSource(ints = {0, -5})
    void case_when_create_round_throws_illegalArgumentException(int round) {
        assertThrows(IllegalArgumentException.class, () -> Round.of(round));
    }

    @DisplayName("0보다 큰 숫자의 라운드 생성 시 정상 생성")
    @ParameterizedTest(name = "{index} {displayName} input value={0}")
    @ValueSource(ints = {1, 3, 9})
    void case_when_create_round_greater_than_0(int round) {
        assertDoesNotThrow(() -> Round.of(round));
    }
}
