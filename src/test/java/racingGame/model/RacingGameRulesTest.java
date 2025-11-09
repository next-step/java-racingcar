package racingGame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingGameRulesTest {
    
    @Test
    void getGameRules() {
        RacingGameRules rules = RacingGameRules.of(2, 2);
        assertThat(rules.getRules()).isNotNull();
    }
    
    @Test
    void carGenerateResultNullTest() {
        assertThatThrownBy(() -> {
            RacingGameRules.of(1, -1);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("%s","참가시킬 자동차 수 입력이 생략되거나, 0이하");
    }
    
    @Test
    void gameTurnSetNullTest() {
        assertThatThrownBy(() -> {
            RacingGameRules.of(-1, 1);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("%s","이동횟수에 입력이 생략되거나, 0이하");
    }

}