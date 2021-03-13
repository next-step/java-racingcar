package carracing.service;

import carracing.domain.Cars;
import carracing.service.dto.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarRacingServiceTest {

    @Test
    @DisplayName("서비스 실행결과 - 입력한 라운드 수 만큼의 라운드 결과가 존재해야 한다")
    void carRacingService_roundCount() {
        // given
        RacingRegisterInfo racingRegisterInfo = new RacingRegisterInfo(3, 5);
        CarRacingService carRacingService = new CarRacingService();

        // when
        RacingResult racingResult = carRacingService.executeCarRacing(racingRegisterInfo);

        // then
        assertThat(5).isEqualTo(racingResult.getRoundResultList().size());
    }

    @Test
    @DisplayName("서비스 실행결과 - 각 라운드 결과에는 입력한 자동차 수 만큼의 성적이 존재해야 한다")
    void carRacingService_racingScoreCount() {
        // given
        RacingRegisterInfo racingRegisterInfo = new RacingRegisterInfo(3, 5);
        CarRacingService carRacingService = new CarRacingService();

        // when
        RacingResult racingResult = carRacingService.executeCarRacing(racingRegisterInfo);

        // then
        for (RoundResult roundResult : racingResult.getRoundResultList()) {
            assertThat(3).isEqualTo(roundResult.getRacingScores().getRacingScoreList().size());
        }
    }

    @Test
    @DisplayName("서비스 실행결과 - 라운드별 성적 리스트의 차량번호는 모두 1 이상이어야 한다.")
    void carRacingService_racingScore_carNumber() {
        // given
        RacingRegisterInfo racingRegisterInfo = new RacingRegisterInfo(3, 5);
        CarRacingService carRacingService = new CarRacingService();

        // when
        RacingResult racingResult = carRacingService.executeCarRacing(racingRegisterInfo);

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
        RacingRegisterInfo racingRegisterInfo = new RacingRegisterInfo(3, 5);
        CarRacingService carRacingService = new CarRacingService();

        // when
        RacingResult racingResult = carRacingService.executeCarRacing(racingRegisterInfo);

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
        RacingRegisterInfo racingRegisterInfo = new RacingRegisterInfo(3, 5);
        CarRacingService carRacingService = new CarRacingService();

        // when
        RacingResult racingResult = carRacingService.executeCarRacing(racingRegisterInfo);

        // then
        for (RoundResult roundResult : racingResult.getRoundResultList()) {
            RacingScores racingScores = roundResult.getRacingScores();
            for (RacingScore racingScore : racingScores.getRacingScoreList()) {
                assertThat(0).isLessThanOrEqualTo(racingScore.getScore());
            }
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "0:6", "0:-1", "-1:0", "-1:100", "-1:9"}, delimiter = ':')
    @DisplayName("입력값 검증 - 참가 자동차 수는 한 대 이상이어야 한다")
    void validate_racingCarCount(int racingCarCount, int roundCount) {
        // given
        CarRacingService carRacingService = new CarRacingService();
        RacingRegisterInfo racingRegisterInfo = new RacingRegisterInfo(racingCarCount, roundCount);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> carRacingService.executeCarRacing(racingRegisterInfo) )
                .withMessageMatching("자동차 등록수는 최소 한 대 이상이어야 합니다.")
                ;
    }

    @ParameterizedTest
    @CsvSource(value = {"5:0", "5:-7", "5:-1"}, delimiter = ':')
    @DisplayName("입력값 검증 - 경기 횟수는 최소 1회 이상이어야 한다")
    void validate_roundCount(int racingCarCount, int roundCount) {
        // given
        CarRacingService carRacingService = new CarRacingService();
        RacingRegisterInfo racingRegisterInfo = new RacingRegisterInfo(racingCarCount, roundCount);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> carRacingService.executeCarRacing(racingRegisterInfo) )
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

    @Test
    @DisplayName("경기점수 등록 - 참가 자동차 수와 경기스코어 수는 같아야 함")
    void registerRacingScore() {
        // given
        Cars cars = new Cars(5);
        RacingScores racingScores = new RacingScores(cars);

        // when then
        assertThat(cars.getCarList().size()).isEqualTo(racingScores.getRacingScoreList().size());
    }

    @Test
    @DisplayName("경기결과 등록 테스트 - 경기횟수 0, 경기결과 미존재")
    void registerRoundResult() {
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new RoundResult(0, new RacingScores(new Cars(1)))
                ).withMessageMatching("라운드 회차는 최소 1 이상이어야 합니다.")
        ;
        assertThatIllegalArgumentException()
                .isThrownBy( () -> new RoundResult(1, null)
                ).withMessageMatching("경기 정보가 존재하지 않습니다.")
        ;
    }
}