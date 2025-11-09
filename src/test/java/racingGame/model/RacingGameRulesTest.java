package racingGame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RacingGameRulesTest {
    
    @Test
    void getGameRules() {
        RacingGameRules rule = new RacingGameRules(2, 2);
        assertThat(rule.getRules()).isNotNull();
    }
    
    @Test
    void carGenerateResultNullTest() {
        assertThatThrownBy(() -> {
            new RacingGameRules(-1, 1);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("%s","참가시킬 자동차 수 입력이 생략되거나, 0이하");
    }
    
    @Test
    void gameTurnSetNullTest() {
        assertThatThrownBy(() -> {
            new RacingGameRules(1, -1);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("%s","이동횟수에 입력이 생략되거나, 0이하");
    }

}