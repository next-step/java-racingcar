package step3_RacingCar_Competition;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarCompetitionTest {
    static RacingCarCompetition racingCarCompetition;

    @BeforeAll
    static void init() {
        racingCarCompetition = new RacingCarCompetition();
    }

    @DisplayName(value = "랜덤값 범위 확인 테스트")
    @RepeatedTest(5)
    void randomNumberTest() {
        assertThat(racingCarCompetition.randomNumber()).isBetween(0, 9);
    }

    @DisplayName(value = "이동, 정지 테스트")
    @ParameterizedTest()
    @CsvSource({"0,false", "1,false", "2,false", "3,false", "4,true", "5,true",
            "6,true", "7,true", "8,true", "9,true"})
    void movingStopDecisionTest(int randomNumber, boolean isMovingCar) {
        assertThat(racingCarCompetition.moveStopDecision(randomNumber)).isEqualTo(isMovingCar);
    }


}