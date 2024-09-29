package step3_RacingCar_Competition;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarCompetitionTest {
    static RacingCarCompetition racingCarCompetition;
    static RacingCarInfo racingCarInfo;
    static int totalCarNumber = 2;
    static int totalMovingCount = 2;
    static ArrayList<ArrayList<Integer>> customMovingData;

    @BeforeAll
    static void init() {
        racingCarCompetition = new RacingCarCompetition();
        racingCarInfo = new RacingCarInfo(totalCarNumber, totalMovingCount);
        customMovingData = new ArrayList<>();
        ArrayList<Integer> innerData = new ArrayList<>();
        innerData.add(1);
        innerData.add(4);
        customMovingData.add(innerData);

        innerData = new ArrayList<>();
        innerData.add(4);
        innerData.add(4);
        customMovingData.add(innerData);

        racingCarCompetition.recordRacingCarData(customMovingData, racingCarInfo);
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
    void movingStopDecisionTest(int randomNumber, boolean isGoStop) {
        assertThat(racingCarCompetition.moveStopDecision(randomNumber)).isEqualTo(isGoStop);
    }

    @DisplayName(value = "차 이동상태 저장 여부 테스트, 차2대,이동 2번")
    @ParameterizedTest()
    @CsvSource({"0,-", "1,--"})
    void recordRacingCarDataTest(int carNumber, String carMovingString) {
        assertThat(racingCarInfo.findRacingCarData(carNumber)).isEqualTo(carMovingString);
    }


}