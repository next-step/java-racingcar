package racing.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.car.usecase.CreateUseCase;
import racing.domain.car.usecase.RacingUseCase;
import racing.dto.CarDto;
import racing.dto.CarRaceDto;
import racing.service.FakeCreateUseCase;
import racing.service.FakeRacingUseCase;

class RacingServiceTest {

    @Test
    @DisplayName("자동차를 생성한다")
    void createCarTest() {
        //given
        CreateUseCase createUseCase = new FakeCreateUseCase();
        int numberOfCar = 3;

        //when
        CarRaceDto carRaceDto = createUseCase.makeCars(numberOfCar);

        //then
        assertThat(carRaceDto.size()).isEqualTo(numberOfCar);
    }

    @Test
    @DisplayName("자동차 움직이는 테스트")
    void moveCarTest() {
        //given
        RacingUseCase racingUseCase = new FakeRacingUseCase();
        CarRaceDto carRaceDto = new CarRaceDto(List.of(
            new CarDto(),
            new CarDto(),
            new CarDto()
        ));

        //when
        CarRaceDto racingGame = racingUseCase.racingGame(carRaceDto);

        //then
        assertThat(carRaceDto).isNotEqualTo(racingGame);
    }
}