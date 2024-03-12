package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.RacingCarGameLogic;
import racingcar.RacingCarGameRule;
import racingcar.Racingcar;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {
    @ParameterizedTest
    @DisplayName("4이상일 경우 전진하는 조건인지 테스트")
    @CsvSource({"3,false", "5,true", "8,true"})
    public void testIsMoving(int input, boolean output) {
        boolean isMoving = RacingCarGameRule.getInstance().isMovingForward(input);
        assertThat(isMoving).isEqualTo(output);
    }

    @Test
    @DisplayName("게임 로직 정상실행 통합 테스트")
    public void testGameLogic() {
        RacingCarGameLogic.getInstance().gameLogic(3,5);
    }

    @Test
    @DisplayName("최대 입력값 초과 테스트")
    public void testMaxInput() {
        boolean isMaxInput = Racingcar.isMaximumInput(10001,10001);
        assertThat(isMaxInput).isTrue();
    }

}
