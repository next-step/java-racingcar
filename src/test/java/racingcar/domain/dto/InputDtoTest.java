package racingcar.domain.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.exception.NameNullPointerException;
import racingcar.domain.exception.TryCountIllegalArgumentException;

public class InputDtoTest {

    private static final String TEST_NAME = "test,test";
    private static final Integer TEST_TRT_COUNT = 5;

    @Test
    @DisplayName("생성 성공")
    void createSuccess() {
        assertThat(InputDto.of(TEST_NAME, TEST_TRT_COUNT)).isInstanceOf(InputDto.class);
    }

    @ParameterizedTest
    @DisplayName("이름이 null 이거나 빈 값일 경우 예외처리")
    @NullAndEmptySource
    void nameNullAndEmptyException(String name) {
        assertThatExceptionOfType(NameNullPointerException.class)
            .isThrownBy(() -> InputDto.of(name, TEST_TRT_COUNT));
    }

    @ParameterizedTest
    @DisplayName("이동횟수가 1보다 작을 경우 예외처리")
    @ValueSource(ints = {0, -1, -2})
    void tryCountRangeException(Integer tryCount) {
        assertThatExceptionOfType(TryCountIllegalArgumentException.class)
            .isThrownBy(() -> InputDto.of(TEST_NAME, tryCount));
    }

    @ParameterizedTest
    @DisplayName("이동횟수가 null 일 경우 예외처리")
    @NullSource
    void tryCountNullException(Integer tryCount) {
        assertThatExceptionOfType(TryCountIllegalArgumentException.class)
            .isThrownBy(() -> InputDto.of(TEST_NAME, tryCount));
    }

}
