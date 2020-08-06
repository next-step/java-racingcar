package racingcar.ui;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.domain.RacingResult;
import racingcar.ui.view.MotorRacingDisplayRoundResult;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.RacingResult.defaultResult;

class MotorRacingDisplayRoundResultTest {
    @DisplayName("레이싱 경기 결과 출력 테스트")
    @ParameterizedTest
    @CsvSource(value={"1,1,-\\n-","2,3,--\\n---"})
    void result(int mileageGaee0, int mileageGaee1, String expected) {
        List<RacingResult> testData = Arrays.asList(defaultResult(mileageGaee0), defaultResult(mileageGaee1));
        MotorRacingDisplayRoundResult motorRacingDisplayRoundResult = new MotorRacingDisplayRoundResult(testData);
        String result = motorRacingDisplayRoundResult.toString();
        assertThat(result.replace("\n", "\\n")).isEqualTo(expected);
    }
}