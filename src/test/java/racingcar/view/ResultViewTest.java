package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {
    @ParameterizedTest
    @CsvSource(value = {"1,-", "2,--", "3,---"})
    @DisplayName("RacingCar 객체의 moveCount 값만큰 전진하는지 체크")
    public void moveCount_만큼_전진(int moveCount, String moveHyphen) {
        assertThat(new ResultView().draw(new RacingCar(moveCount))).isEqualTo(moveHyphen);
    }
}
