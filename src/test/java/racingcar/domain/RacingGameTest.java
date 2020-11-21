package racingcar.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.input.CarNames;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;
import racingcar.domain.racing.RacingGame;
import racingcar.dto.input.RacingCount;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private static final CarNames CAR_NAMES = new CarNames("damas,bmw,benz");
    private static final RacingGame racingGame = new RacingGame();
    private static final CarFactory carFactory = new CarFactory();


    @ParameterizedTest
    @DisplayName("경기를 n번 진행하면, n개의 record가 쌓인다")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void should_save_records_when_playing_4_matches(int count) {
        //Given
        Cars cars = carFactory.createCars(CAR_NAMES);
        RacingCount racingCount = new RacingCount(count);

        //When
        List<Cars> start = racingGame.startRacingGame(cars, racingCount);

        //Then
        assertThat(start.size()).isEqualTo(racingCount.getValue());

    }

}
