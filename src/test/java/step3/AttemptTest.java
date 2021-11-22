package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AttemptTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, -100000000})
    @DisplayName("0이하의 시도 횟수를 가진 Attempt 객체 생성 시도시 IllegalArgumentException가 발생하는지 확인합니다")
    void illegalAttempt(int number) {
        assertThatThrownBy(() -> {
            new Attempt(number);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1, true", "4, false"})
    @DisplayName("시도 횟수를 차감하는 메소드가 정상적으로 작동하는지 확인합니다")
    void testIsEnd(int number, boolean expect) {
        Attempt attempt = new Attempt(number);
        attempt.make();
        boolean isEnd = attempt.isEnd();
        assertThat(isEnd).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Attempt 객체 생성시 number가 정상인지 확인합니다")
    void isEqualNumber(int number) {
        Attempt attempt = new Attempt(number);
        boolean result = attempt.isEqualNumber(number);
        assertThat(result).isTrue();
    }


}