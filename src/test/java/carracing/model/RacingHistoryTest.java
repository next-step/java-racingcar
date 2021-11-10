package carracing.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import carracing.exception.RacingHistoryOutBoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingHistoryTest {

    private static final Boolean TRUE = true;

    @ParameterizedTest
    @ValueSource(ints = 1)
    @DisplayName("레이싱이력 Index 로 가져오기 성공 확인")
    void getIsTrySuccess(Integer size) {
        RacingHistory history = new RacingHistory();
        history.addHistory(TRUE);
        assertThat(history.getIsTrySuccess(size).size()).isEqualTo(size);
    }

    @ParameterizedTest
    @ValueSource(ints = 2)
    @DisplayName("레이싱이력 Index 로 가져오기 실패 확인")
    void getIsTrySuccessException(Integer size) {
        RacingHistory history = new RacingHistory();
        history.addHistory(TRUE);

        assertThatExceptionOfType(RacingHistoryOutBoundException.class)
            .isThrownBy(() -> history.getIsTrySuccess(size));
    }

}
