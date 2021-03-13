package carracing.service;

import carracing.domain.Cars;
import carracing.service.dto.RacingRegisterInfo;
import carracing.service.dto.RacingScores;
import carracing.service.dto.RoundResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarRacingServiceTest {

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