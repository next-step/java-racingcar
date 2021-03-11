package carracing.service;

import carracing.domain.Car;
import carracing.domain.CarService;
import carracing.service.dto.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

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

    @Test
    @DisplayName("경기점수 등록")
    void registerRacingScore() {
        // given
        RacingScores racingScores = new RacingScores();
        CarService carService = new CarService();
        Car car = carService.registerCar(1);

        // when
        car.drive();
        racingScores.registerRacingScore(car);
        Optional<RacingScore> registeredScore = racingScores.getRacingScoreList().stream().filter(racingScore -> racingScore.getCarNumber() == car.getCarNumber()).findAny();

        // then
        assertThat(registeredScore.isPresent()).isTrue();
        assertThat(registeredScore.get().getCarNumber()).isEqualTo(car.getCarNumber());
        assertThat(registeredScore.get().getScore()).isEqualTo(car.getMileage());
    }

    @Test
    @DisplayName("경기점수 등록 - 같은 차량의 점수를 등록할 경우, 기존 차량 점수 업데이트")
    void registerRacingScore_registerSameCar() {
        // given
        RacingScores racingScores = new RacingScores();
        CarService carService = new CarService();
        Car car = carService.registerCar(1);

        // when
        int beforeMileage = car.getMileage();
        while (beforeMileage==car.getMileage()) {
            car.drive();
        }
        beforeMileage = car.getMileage();
        racingScores.registerRacingScore(car);
        while (beforeMileage==car.getMileage()) {
            car.drive();
        }

        Optional<RacingScore> registeredRacingScore = racingScores.getRacingScoreList().stream()
                .filter(racingScore -> racingScore.getCarNumber() == car.getCarNumber())
                .findAny();

        // then
        assertThat(beforeMileage).isNotEqualTo(car.getMileage());
        assertThat(racingScores.getRacingScoreList().size()).isEqualTo(1);
        assertThat(registeredRacingScore.isPresent()).isTrue();
        assertThat(registeredRacingScore.get().getCarNumber()).isEqualTo(car.getCarNumber());
    }

    @Test
    @DisplayName("경기결과 등록 테스트 - 경기횟수 0, 경기결과 미존재")
    void registerRoundResult() {
        // given
        RoundResult roundResult = new RoundResult();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy( () ->
                    roundResult.registerRoundResult(0, new RacingScores())
                ).withMessageMatching("경기 횟수는 최소 1회 이상이어야 합니다.")
        ;

        assertThatIllegalArgumentException()
                .isThrownBy( () ->
                    roundResult.registerRoundResult(1, new RacingScores()))
                .withMessageMatching("경기 정보가 존재하지 않습니다.")
        ;
    }

    @Test
    @DisplayName("경기결과 등록 테스트 - 중복등록")
    void registerRoundResult_Dup() {
        // given
        RoundResult roundResult = new RoundResult();
        RacingScores racingScores = new RacingScores();
        CarService carService = new CarService();
        Car car = carService.registerCar(1);

        // when
        car.drive();
        racingScores.registerRacingScore(car);
        roundResult.registerRoundResult(1, racingScores);

        // then
        assertThatIllegalArgumentException()
                .isThrownBy( () ->
                    roundResult.registerRoundResult(1, racingScores)
                ).withMessageMatching("해당 경기 정보는 이미 등록되었습니다.")
        ;
    }
}