package me.daeho.step3;

import me.daeho.step3.rule.DefaultForwardRule;
import me.daeho.step3.rule.ForwardRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@DisplayName("자동차 경주 테스트")
class RacingGameTest {
    private static final ForwardRule DEFAULT_RULE = new DefaultForwardRule();
    private static final String[] DEFAULT_CAR_NAMES = {"foo", "bar", "baz"};
    private static final int DEFAULT_TIME = 5;

    @DisplayName("남은 횟수 확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:true", "0:false"}, delimiter = ':')
    public void initAndHasNextTest(int time, boolean expectedValue) {
        RacingGame racingGame = RacingGame.init(DEFAULT_RULE, DEFAULT_CAR_NAMES, time);
        assertThat(racingGame.hasNext()).isEqualTo(expectedValue);
    }

    @DisplayName("남은 횟수 차감 테스트")
    @Test
    public void subtractTimeTest() {
        RacingGame racingGame = RacingGame.init(DEFAULT_RULE, DEFAULT_CAR_NAMES, 1);

        assertThat(racingGame.hasNext()).isTrue();
        racingGame.move();
        assertThat(racingGame.hasNext()).isFalse();
    }

    @DisplayName("설정된 자동차 대수와 결과 값의 자동차 대수 비교 테스트")
    @Test
    public void carCountCompareTest() {
        RacingGame racingGame = RacingGame.init(DEFAULT_RULE, DEFAULT_CAR_NAMES, DEFAULT_TIME);
        assertThat(racingGame.move().size()).isEqualTo(DEFAULT_CAR_NAMES.length);
    }

    @DisplayName("우승 자동차 테스트")
    @Test
    public void winningCarsTest() {
        ForwardRule forwardRule = Mockito.mock(DefaultForwardRule.class);
        given(forwardRule.isForward()).willReturn(true);
        RacingGame racingGame = RacingGame.init(forwardRule, DEFAULT_CAR_NAMES, DEFAULT_TIME);

        while(racingGame.hasNext()) {
            racingGame.move();
        }

        assertThat(racingGame.winningCars().size()).isEqualTo(DEFAULT_CAR_NAMES.length);
    }
}
