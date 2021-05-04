package racing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingServiceTest {
    private RacingService racingService;

    @BeforeEach
    void setup() {
        racingService = new RacingService(() -> true);
    }

    @DisplayName("race 결과 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"'bmw,benz,audi', 3", "'a,b,c,d,e', 5"})
    void race(String carNames, int numberOfRounds) {
        RacingResult racingResult = racingService.race(carNames, numberOfRounds);
        List<RoundResult> roundResults = racingResult.getRoundResults();
        String[] splitCarNames = carNames.split(Cars.DELIMITER);

        assertThat(roundResults.size()).isEqualTo(numberOfRounds);
        for (int i = 0; i < roundResults.size(); i++) {
            assertThat(roundResults.get(i).getRound()).isEqualTo(Round.of(i + 1));
            List<CarDto> carDtos = roundResults.get(i).getCarDtos();
            assertThat(carDtos.size()).isEqualTo(splitCarNames.length);
            checkCarDtos(carDtos, carNames, i + 1);
        }
        assertThat(racingResult.getWinners().size()).isEqualTo(splitCarNames.length);
    }

    void checkCarDtos(List<CarDto> carDtos, String carNames, int distance) {
        for (CarDto carDto : carDtos) {
            assertThat(carNames).contains(carDto.getCarName());
            assertThat(carDto.getDistance()).isEqualTo(distance);
        }
    }
}
