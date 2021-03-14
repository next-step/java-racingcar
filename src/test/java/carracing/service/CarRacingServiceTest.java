package carracing.service;

import carracing.controller.dto.CarRacingRequest;
import carracing.domain.Cars;
import carracing.service.dto.RacingResult;
import carracing.service.dto.RacingScore;
import carracing.service.dto.RacingScores;
import carracing.service.dto.RoundResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarRacingServiceTest {

    @Test
    @DisplayName("서비스 실행결과 - 입력한 라운드 수 만큼의 라운드 결과가 존재해야 한다")
    void carRacingService_roundCount() {
        // given
        CarRacingRequest carRacingRequest = new CarRacingRequest(3, 5);
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
        CarRacingRequest carRacingRequest = new CarRacingRequest(3, 5);
        CarRacingService carRacingService = new CarRacingService();

        // when
        RacingResult racingResult = carRacingService.executeCarRacing(carRacingRequest);

        // then
        for (RoundResult roundResult : racingResult.getRoundResultList()) {
            assertThat(3).isEqualTo(roundResult.getRacingScores().getRacingScoreList().size());
        }
    }

    @Test
    @DisplayName("서비스 실행결과 - 라운드별 성적 리스트의 차량번호는 모두 1 이상이어야 한다.")
    void carRacingService_racingScore_carNumber() {
        // given
        CarRacingRequest carRacingRequest = new CarRacingRequest(3, 5);
        CarRacingService carRacingService = new CarRacingService();

        // when
        RacingResult racingResult = carRacingService.executeCarRacing(carRacingRequest);

        // then
        for (RoundResult roundResult : racingResult.getRoundResultList()) {
            RacingScores racingScores = roundResult.getRacingScores();
            for (RacingScore racingScore : racingScores.getRacingScoreList()) {
                assertThat(1).isLessThanOrEqualTo(racingScore.getCarNumber());
            }
        }
    }

    @Test
    @DisplayName("서비스 실행결과 - 라운드별 성적 리스트에는 차량당 한 개의 성적만 존재해야 한다")
    void carRacingService_racingScore_scoreCount() {
        // given
        CarRacingRequest carRacingRequest = new CarRacingRequest(3, 5);
        CarRacingService carRacingService = new CarRacingService();

        // when
        RacingResult racingResult = carRacingService.executeCarRacing(carRacingRequest);

        // then
        for (RoundResult roundResult : racingResult.getRoundResultList()) {
            RacingScores racingScores = roundResult.getRacingScores();
            for (RacingScore racingScore : racingScores.getRacingScoreList()) {
                long count = racingScores.getRacingScoreList().stream().filter(score -> racingScore.getCarNumber() == score.getCarNumber()).count();
                assertThat(1).isEqualTo(count);
            }
        }
    }

    @Test
    @DisplayName("서비스 실행결과 - 라운드별 성적 리스트의 성적은 0 이상이다")
    void carRacingService_racingScore_score() {
        // given
        CarRacingRequest carRacingRequest = new CarRacingRequest(3, 5);
        CarRacingService carRacingService = new CarRacingService();

        // when
        RacingResult racingResult = carRacingService.executeCarRacing(carRacingRequest);

        // then
        for (RoundResult roundResult : racingResult.getRoundResultList()) {
            RacingScores racingScores = roundResult.getRacingScores();
            for (RacingScore racingScore : racingScores.getRacingScoreList()) {
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
                .isThrownBy( () -> new CarRacing(roundCount, new Cars(5)) )
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

    @ParameterizedTest
    @CsvSource(value = {"0:0", "0:6", "0:-1", "-1:0", "-1:100", "-1:9"}, delimiter = ':')
    @DisplayName("입력값 검증 - 참가 자동차 수는 한 대 이상이어야 한다")
    void validate_racingCarCount(int racingCarCount, int roundCount) {
        // given
        CarRacingService carRacingService = new CarRacingService();
        CarRacingRequest carRacingRequest = new CarRacingRequest(racingCarCount, roundCount);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> carRacingService.executeCarRacing(carRacingRequest) )
                .withMessageMatching("자동차 등록수는 최소 한 대 이상이어야 합니다.")
                ;
    }

    @ParameterizedTest
    @CsvSource(value = {"5:0", "5:-7", "5:-1"}, delimiter = ':')
    @DisplayName("입력값 검증 - 경기 횟수는 최소 1회 이상이어야 한다")
    void validate_roundCount(int racingCarCount, int roundCount) {
        // given
        CarRacingService carRacingService = new CarRacingService();
        CarRacingRequest carRacingRequest = new CarRacingRequest(racingCarCount, roundCount);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> carRacingService.executeCarRacing(carRacingRequest) )
                .withMessageMatching("경기 횟수는 최소 1회 이상이어야 합니다.")
        ;
    }

    @Test
    @DisplayName("플레이어 등록 테스트 - 차량정보 필수입력")
    void registerPlayer() {
        // given when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new Cars(0) )
                .withMessageMatching("자동차 등록수는 최소 한 대 이상이어야 합니다.")
        ;
    }
}