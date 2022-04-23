package newcarracing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void 경주용_자동차(String input) {
        RacingCar racingCar = new RacingCar(input);
        assertThat(racingCar.getName()).isEqualTo(input);
    }

    @Test
    void 경주용_자동차_이름_길이_제한초과() {
        assertThatThrownBy(() -> {
            RacingCar racingCar = new RacingCar("carname");
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("초과")
        ;
    }

    @Test
    void 경주용_자동차_전진_실패() {
        RacingCar racingCar = new RacingCar("pobi");
        racingCar.moveForward(createFalseCondition());
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @Test
    void 경주용_자동차_한칸_전진_성공_결과_리턴() {
        RacingCar racingCar = new RacingCar("pobi");
        racingCar.moveForward(createTrueCondition());
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    private GameRule createFalseCondition() {
        GameRule gameRule = new GameRule();
        gameRule.setRuleCondition(() -> false);
        return gameRule;
    }

    private GameRule createTrueCondition() {
        GameRule gameRule = new GameRule();
        gameRule.setRuleCondition(() -> true);
        return gameRule;
    }
}