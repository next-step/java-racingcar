package racingCar.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingCar.domain.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value={"2,2", "2,5"})
    @DisplayName("자동차 Position 초기값 설정")
    void initRacingCars(int carCount, int time) {
        RacingGame racingGame = new RacingGame(carCount, time);
        List<RacingCar> racingCarList = racingGame.getRacingCarList();

        racingCarList = racingCarList.stream()
                                    .filter(racingCar -> racingCar.getPosition() == 0)
                                    .collect(Collectors.toList());
        
        assertThat(racingCarList.size()).isEqualTo(carCount);
    }
}
