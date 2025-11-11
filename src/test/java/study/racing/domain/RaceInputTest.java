package study.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class RaceInputTest {

    @Test
    @DisplayName("정상 입력으로 RaceInput 객체를 생성한다.")
    void createSuccess() {
        RaceInput race = new RaceInput("car1,car2,car3", 2);
        assertThat(race.getNames().size()).isEqualTo(3);
        assertThat(race.getNumberOfAttempt()).isEqualTo(2);
    }


    @DisplayName("시도 횟수가 1미만일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void throwExceptionAttemptNumber(int numberOfAttempt) {
        assertThatThrownBy(() -> new RaceInput("car1,car2", numberOfAttempt))
                .isInstanceOf(RuntimeException.class);
    }

    @NullAndEmptySource
    @ParameterizedTest
    void 이름이_null_또는_빈값이면_예외발생(String name) {
        assertThatThrownBy(() -> new RaceInput(name, 2))
                .isInstanceOf(RuntimeException.class);
    }

}