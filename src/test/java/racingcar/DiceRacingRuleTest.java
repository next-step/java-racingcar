package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class DiceRacingRuleTest {

    @DisplayName("0~3 의 Dice 숫자가 나왔을 때 앞으로 이동할 수 가 0으로 나오는 지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void doNotMoveTest(int diceNumber) {
        DiceRacingRule raceRule = new DiceRacingRule(() -> diceNumber);

        int forwardMoveCount = raceRule.getMoveForward();

        assertThat(forwardMoveCount).isEqualTo(0);
    }

    @DisplayName("4~9 의 Dice 숫자가 나왔을 때 앞으로 이동할 수가 1인지 테스트 ")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7})
    public void moveForwardTest(int diceNumber) {
        DiceRacingRule raceRule = new DiceRacingRule(() -> diceNumber);

        int forwardMoveCount = raceRule.getMoveForward();

        assertThat(forwardMoveCount).isEqualTo(1);

    }
}