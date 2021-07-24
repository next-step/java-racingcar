package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarInputTest {
    @DisplayName("입력값의 범위가 벗어날 경우 에러메세지가 정확히 나타나는지 확인")
    @Test
    void 입력값테스트(int cnt, int threthold) {
        String errorMessage = "자동차의 수가 너무 적거나 많습니다.";
        if (0 >= cnt || cnt > threthold) {
             throw new IllegalArgumentException(errorMessage);
        }
    }
    @DisplayName("입력값 테스트 실행부분 (오류가 발생해야 하는 경우)")
    @ParameterizedTest
    @CsvSource(value = {"0,9,자동차의 수가 너무 적거나 많습니다.", "10,9,자동차의 수가 너무 적거나 많습니다."})
    void 입력값테스트실행1(int cnt, int threthold, String errorMessage) {
        Assertions.assertThatThrownBy(() -> {
            입력값테스트(cnt, threthold);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(errorMessage);
    }

    @DisplayName("입력값 테스트 실행부분 (오류가 발생하지 않는 경우)")
    @ParameterizedTest
    @CsvSource(value = {"1,9","2,9","3,9","4,9","5,9","6,9","7,9","8,9","9,9"})
    void 입력값테스트실행2(int cnt, int threthold) {
        입력값테스트(cnt, threthold);
    }

}