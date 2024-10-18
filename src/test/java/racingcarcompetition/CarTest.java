package racingcarcompetition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    
    @DisplayName(value = "차 이동상태 판단 기능 테스트")
    @ParameterizedTest()
    @CsvSource(value = {"3,''", "4,-"})
    void moveStopDecisionTest(char randomNumber, String resultMovingString) {
        assertThat(ResultView.moveStopDecision(randomNumber))
                .isEqualTo(resultMovingString);
    }

    @DisplayName(value = "차 이동상태 저장 확인 테스트, 차2대,이동 2번")
    @ParameterizedTest()
    @CsvSource(value = {"33,''", "34,-", "43,-", "44,--"})
    void findRacingCarDataTest(String movingData, String expectedResultString) {
        assertThat(ResultView.convertMovingData(movingData))
                .isEqualTo(expectedResultString);
    }
}
