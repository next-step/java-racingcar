package racing.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.dto.CarDto;
import racing.dto.CarRaceDto;

class RacingControllerTest {

    private RacingController racingController = new RacingController();

    @Test
    @DisplayName("자동차 만들기 테스트")
    void createCarTest() {
        //given
        int numberOfCars = 3;

        //when
        CarRaceDto carRaceDto = racingController.makeCars(numberOfCars);

        //then
        assertThat(carRaceDto.size()).isEqualTo(numberOfCars);
    }

    @Test
    @DisplayName("자동차 레이싱 경주")
    void racingGameTest() {
        //given
        CarRaceDto carRaceDto = new CarRaceDto(List.of(
            new CarDto(),
            new CarDto(),
            new CarDto()
        ));

        //when
        racingController.racingGame(carRaceDto);

        //then

    }

}