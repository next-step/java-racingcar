package carracing.controller;

import carracing.controller.dto.CarRacingRequest;
import carracing.service.dto.RacingResult;
import carracing.service.dto.RoundResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingControllerTest {

    @Test
    @DisplayName("경기 실행 시 입력한 라운드 카운트와 결과값의 라운드 리스트 크기는 같아야 한다.")
    void executeCarRacing_roundCount() {
        
        // given
        CarRacingRequest carRacingRequest = new CarRacingRequest("pobi,crong,honux,", 5);

        // when
        CarRacingController carRacingController = new CarRacingController();
        RacingResult racingResult = carRacingController.executeCarRacing(carRacingRequest);

        // then
        assertThat(racingResult.getRoundResultList().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("경기 실행 시 입력한 차량의 수와 라운드별 점수개수의 크기는 같아야 한다.")
    void executeCarRacing_racingCarCount() {

        // given
        CarRacingRequest carRacingRequest = new CarRacingRequest("pobi,crong,honux,", 5);

        // when
        CarRacingController carRacingController = new CarRacingController();
        RacingResult racingResult = carRacingController.executeCarRacing(carRacingRequest);

        // then
        for (RoundResult roundResult : racingResult.getRoundResultList()) {
            assertThat(roundResult.getRacingScoreList().size()).isEqualTo(3);
        }
    }
}