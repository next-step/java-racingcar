package carracing.service;

import carracing.domain.Car;
import carracing.domain.CarService;
import carracing.service.dto.Players;
import carracing.service.dto.RacingRegisterInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("플레이어 등록 테스트 - 차량정보 필수입력")
    void registerPlayer() {
        // given
        Players players = new Players();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> players.registerPlayer(null) )
                .withMessageMatching("차량정보를 입력해 주세요.")
        ;
    }

    @Test
    @DisplayName("플레이어 등록 테스트 - 차량정보 중복등록 불가")
    void registerPlayer_dup() {
        // given
        Players players = new Players();
        CarService carService = new CarService();
        Car car1 = carService.registerCar(1);

        players.registerPlayer(car1);

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> players.registerPlayer(car1) )
                .withMessageMatching("이미 등록된 차량입니다.")
        ;
    }
}