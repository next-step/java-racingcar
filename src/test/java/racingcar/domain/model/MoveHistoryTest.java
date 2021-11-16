package racingcar.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.exception.HistoryOutOfBoundsException;

public class MoveHistoryTest {

    @Test
    @DisplayName("이력 객체 생성")
    void createMoveHistory() {
        assertThat(MoveHistory.create()).isEqualTo(MoveHistory.create());
    }

    @ParameterizedTest
    @DisplayName("값 저장 확인")
    @CsvSource(value = {"true:2", "false:1"}, delimiter = ':')
    void addHistory(boolean bool, int size) {
        //given
        MoveHistory moveHistory = MoveHistory.create();

        //when
        moveHistory.addHistory(true);
        moveHistory.addHistory(bool);

        //then
        assertThat(moveHistory.size(bool)).isEqualTo(size);
    }

    @ParameterizedTest
    @DisplayName("이동 성공 횟수 가져오기")
    @CsvSource(value = "4,2")
    void getSuccessCount(int size, int count) {
        MoveHistory moveHistory = MoveHistory.of(Arrays.asList(true, false, true, false));
        assertThat(moveHistory.getSuccessCount(size)).isEqualTo(count);
    }

    @ParameterizedTest
    @DisplayName("이동 성공 횟수 가져올 때 예외처리")
    @ValueSource(ints = {5, 6, 7})
    void getSuccessCountException(int size) {
        MoveHistory moveHistory = MoveHistory.of(Arrays.asList(true, false, true, false));
        assertThatExceptionOfType(HistoryOutOfBoundsException.class)
            .isThrownBy(() -> moveHistory.getSuccessCount(size));
    }

}
