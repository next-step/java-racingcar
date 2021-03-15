package carracing.controller;

import carracing.controller.dto.CarRacingRequest;
import carracing.controller.dto.CarRacingResponse;
import carracing.controller.dto.RoundResultInfo;
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
        CarRacingResponse carRacingResponse = carRacingController.executeCarRacing(carRacingRequest);

        // then
        assertThat(carRacingResponse.getRoundResultList().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("경기 실행 시 입력한 차량의 수와 라운드별 점수개수의 크기는 같아야 한다.")
    void executeCarRacing_racingCarCount() {

        // given
        CarRacingRequest carRacingRequest = new CarRacingRequest("pobi,crong,honux,", 5);

        // when
        CarRacingController carRacingController = new CarRacingController();
        CarRacingResponse carRacingResponse = carRacingController.executeCarRacing(carRacingRequest);

        // then
        for (RoundResultInfo roundResultInfo : carRacingResponse.getRoundResultList()) {
            assertThat(roundResultInfo.getRacingScoreInfoList().size()).isEqualTo(3);
        }
    }
}