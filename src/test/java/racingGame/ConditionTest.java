package racingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ConditionTest {

    private Condition condition;

    @BeforeEach
    void setUp() {
        condition = new Condition();
    }

    @ParameterizedTest
    @CsvSource(value = {"2:false", "4:true", "9:true", "3:false"}, delimiter = ':')
    @DisplayName("랜덤한 숫자를 입력으로 Condition 의 상태를 체크 (기준 숫자: 4 )")
    void initStatus(int input, boolean expected) {
        condition.initStatus(input);

        assertThat(condition.isOk()).isEqualTo(expected);
    }
}