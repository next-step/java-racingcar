package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racingcar.ui.dto.MotorRacingDisplayResults;

import static org.assertj.core.api.Assertions.assertThat;

public class MotorRacingTest {
    @DisplayName("선택한 차량별로 모두 전진했을 때, 예상 처리결과 확인")
    @ParameterizedTest
    @CsvSource(value={
          "3,1,-\\n-\\n-"
        , "3,2,-\\n-\\n-\\n\\n--\\n--\\n--"
        , "3,3,-\\n-\\n-\\n\\n--\\n--\\n--\\n\\n---\\n---\\n---"
    }, delimiter = ',')
    void test(int carCount, int raceRound, String expected){
        MotorRacingRule positiveMotorRacingRule = () -> true;
        MotorRacing motorRacing = new MotorRacing(carCount, positiveMotorRacingRule);
        MotorRacingDisplayResults motorRacingDisplayResults = motorRacing.racing(raceRound);
        String result = motorRacingDisplayResults.toString();
        assertThat(result.replace("\n", "\\n")).isEqualTo(expected);
    }
}
