package step3RacingCarCompetition;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarCompetitionTest {
    RacingCarCompetition racingCarCompetition;
    RacingCarInfo racingCarInfo;

    @BeforeEach
    void init() {
        racingCarCompetition = new RacingCarCompetition();
        racingCarInfo = new RacingCarInfo(2);
        racingCarInfo.recordGoInRacingCarData(0, "-");
        racingCarInfo.recordGoInRacingCarData(1, "--");
    }

    @DisplayName(value = "랜덤값 범위 확인 테스트")
    @RepeatedTest(5)
    void randomNumberTest() {
        assertThat(racingCarCompetition.randomNumber()).isBetween(0, 9);
    }

    @DisplayName(value = "이동, 정지 테스트")
    @ParameterizedTest()
    @CsvSource({"3,''", "4,-"})
    void movingStopDecisionTest(int randomNumber, String isGoStop) {
        assertThat(racingCarCompetition.moveStopDecision(randomNumber)).isEqualTo(isGoStop);
    }

    @Test
    @DisplayName(value = "차 이동상태 저장 기능 테스트")
    void recordRacingCarDataTest() {
        racingCarInfo.recordGoInRacingCarData(0, "-");
        assertThat(racingCarInfo.findRacingCarData(0)).isEqualTo("--");
    }

    @Test
    @DisplayName(value = "차 이동상태 저장 확인 테스트, 차2대,이동 2번")
    void findRacingCarDataTest() {
        assertThat(racingCarInfo.findRacingCarData(1)).isEqualTo("--");
    }
}