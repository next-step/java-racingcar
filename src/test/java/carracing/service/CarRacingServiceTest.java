package carracing.service;

import carracing.service.dto.RacingRegisterInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarRacingServiceTest {

    @ParameterizedTest
    @CsvSource(value = {"0:0", "0:6", "0:-1", "-1:0", "-1:100", "-1:9"}, delimiter = ':')
    @DisplayName("입력값 검증 - 참가 자동차 수는 한 대 이상이어야 한다")
    void validate_racingCarCount(int racingCarCount, int roundCount) {
        // given
        CarRacingService carRacingService = new CarRacingService();
        RacingRegisterInfo racingRegisterInfo = new RacingRegisterInfo();
        racingRegisterInfo.setRacingCarCount(racingCarCount);
        racingRegisterInfo.setRoundCount(roundCount);

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
        RacingRegisterInfo racingRegisterInfo = new RacingRegisterInfo();
        racingRegisterInfo.setRacingCarCount(racingCarCount);
        racingRegisterInfo.setRoundCount(roundCount);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> carRacingService.executeCarRacing(racingRegisterInfo) )
                .withMessageMatching("경기 횟수는 최소 1회 이상이어야 합니다.")
        ;
    }
}