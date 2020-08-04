package racingcar.ui.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.RacingResult;

import static org.assertj.core.api.Assertions.assertThat;

class MotorRacingDisplayWinnerResultsTest {
    @DisplayName("레이싱 성정 누적 정보 테스트")
    @Test
    void winnerAccumulateRacingTotalMileageTest() {
        MotorRacingDisplayWinnerResults winnerResults = new MotorRacingDisplayWinnerResults();
        winnerResults.accumulateRacingTotalMileage(RacingResult.namedResult("a",5));
        winnerResults.accumulateRacingTotalMileage(RacingResult.namedResult("a",5));
        winnerResults.accumulateRacingTotalMileage(RacingResult.namedResult("a",5));
        assertThat(winnerResults.getMaxTotalMileage()).isEqualTo(15);
    }

    @DisplayName("레이싱 승자 리스트 테스트")
    @Test
    void winnerTest() {
        MotorRacingDisplayWinnerResults winnerResults = new MotorRacingDisplayWinnerResults();
        winnerResults.accumulateRacingTotalMileage(RacingResult.namedResult("a",5));
        winnerResults.accumulateRacingTotalMileage(RacingResult.namedResult("b",5));
        winnerResults.accumulateRacingTotalMileage(RacingResult.namedResult("a",5));
        winnerResults.accumulateRacingTotalMileage(RacingResult.namedResult("c",5));
        winnerResults.accumulateRacingTotalMileage(RacingResult.namedResult("a",5));
        winnerResults.accumulateRacingTotalMileage(RacingResult.namedResult("b",5));
        winnerResults.accumulateRacingTotalMileage(RacingResult.namedResult("b",5));
        assertThat(winnerResults.getWinners()).contains("a","b");
    }
}