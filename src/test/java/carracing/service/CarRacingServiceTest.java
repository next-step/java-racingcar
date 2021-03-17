package carracing.service;

import carracing.controller.dto.CarRacingRequest;
import carracing.domain.Cars;
import carracing.service.dto.RacingResult;
import carracing.service.dto.RacingScore;
import carracing.service.dto.RoundResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarRacingServiceTest {

    @Test
    @DisplayName("서비스 실행결과 - 입력한 라운드 수 만큼의 라운드 결과가 존재해야 한다")
    void carRacingService_roundCount() {
        // given
        CarRacingRequest carRacingRequest = new CarRacingRequest("pobi,crong,honux,", 5);
        CarRacingService carRacingService = new CarRacingService();

        // when
        RacingResult racingResult = carRacingService.executeCarRacing(carRacingRequest);

        // then
        assertThat(5).isEqualTo(racingResult.getRoundResultList().size());
    }

    @Test
    @DisplayName("서비스 실행결과 - 각 라운드 결과에는 입력한 자동차 수 만큼의 성적이 존재해야 한다")
    void carRacingService_racingScoreCount() {
        // given
        CarRacingRequest carRacingRequest = new CarRacingRequest("pobi,crong,honux,", 5);
        CarRacingService carRacingService = new CarRacingService();

        // when
        RacingResult racingResult = carRacingService.executeCarRacing(carRacingRequest);

        // then
        for (RoundResult roundResult : racingResult.getRoundResultList()) {
            assertThat(3).isEqualTo(roundResult.getRacingScoreList().size());
        }
    }

    @Test
    @DisplayName("서비스 실행결과 - 라운드별 성적 리스트의 성적은 0 이상이다")
    void carRacingService_racingScore_score() {
        // given
        CarRacingRequest carRacingRequest = new CarRacingRequest("pobi,crong,honux,", 5);
        CarRacingService carRacingService = new CarRacingService();

        // when
        RacingResult racingResult = carRacingService.executeCarRacing(carRacingRequest);

        // then
        for (RoundResult roundResult : racingResult.getRoundResultList()) {
            for (RacingScore racingScore : roundResult.getRacingScoreList()) {
                assertThat(0).isLessThanOrEqualTo(racingScore.getScore());
            }
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("CarRacing - 경기 횟수는 최소 1회 이상이어야 함")
    void carRacing_validateRoundCount(int roundCount) {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new CarRacing(roundCount, new Cars("pobi,crong,honux")) )
                .withMessageMatching("경기 횟수는 최소 1회 이상이어야 합니다.");
    }

    @Test
    @DisplayName("CarRacing - 차량정보 필수입력")
    void carRacing_validateRoundCount() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new CarRacing(5, null) )
                .withMessageMatching("차량정보를 입력해 주세요.");
    }

    @Test
    @DisplayName("경기 실행결과 한 명 이상의 우승자는 반드시 존재한다.")
    void carRacing_winnerCount() {
        // given
        CarRacing carRacing = new CarRacing(5, new Cars("pobi,crong,honux"));

        // when
        RacingResult racingResult = carRacing.executeRacing();

        // then
        assertThat(1).isLessThanOrEqualTo(racingResult.getWinners().count());
    }

}