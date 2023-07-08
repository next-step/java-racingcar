package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CountTest {

    @DisplayName("시도 횟수의 입력이 0 이상의 정수인 경우 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"5", "11", " 11 ", "7 ", "0"})
    void 시도_횟수_입력_검증_성공(String count) {
        assertThatNoException()
                .isThrownBy(() -> new Count(count));
    }

    @DisplayName("시도 횟수의 입력이 음수이거나 정수가 아닌 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"5.1", "-999", " ARA ", "1 1"})
    void 시도_횟수_입력검증_실패(String count) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Count(count));
    }

    @DisplayName("음의 실행 횟수는 존재할 수 없다")
    @Test
    void 시도_횟수_음수_존재_불가(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Count(-1));
    }

    @DisplayName("시도할 횟수는 매 번 줄어든다")
    @Test
    void 시도_횟수_매번_줄어듦() {
        Count count = new Count(1);

        assertThat(count.tryOnce()).isEqualTo(new Count(0));
    }

    @DisplayName("1 이상의 횟수일 경우 실행 횟수가 남아 있음이 확인된다")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 100})
    void 시도_횟수_남음(int count) {
        Count remainingCount = new Count(count);

        assertThat(remainingCount.isRemaining()).isEqualTo(true);
    }

    @DisplayName("남은 횟수가 0일 경우 더 이상 실행할 수 없다")
    @Test
    void 시도_횟수_없음() {
        Count remainingCount = new Count(0);

        assertThat(remainingCount.isRemaining()).isEqualTo(false);
    }

}
