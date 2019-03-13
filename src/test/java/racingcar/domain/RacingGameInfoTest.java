package racingcar.domain;

import org.junit.Test;
import racingcar.vo.RacingGameRound;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameInfoTest {

    private List<String> carNames = Arrays.asList("pobi", "crong", "honux");
    private int totalRound = 5;

    @Test
    public void 다음_라운드_여부_확인() {
        // give
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        RacingGameRound racingGameRound = new RacingGameRound(totalRound);

        // when
        RacingGameInfo racingGameInfo = new RacingGameInfo(cars, racingGameRound);

        // then
        assertThat(racingGameInfo.hasNextRound()).isTrue();

        for (int i = 0; i < totalRound; i++) {
            racingGameInfo.incrementCurrentRound();
        }

        assertThat(racingGameInfo.hasNextRound()).isFalse();
    }

    @Test
    public void RacingGameInfo_초기화() {
        // given
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        int value = Car.MOVE_THRESHOLD + 1;
        cars.forEach(car -> car.goWhenGreaterThanThreshold(value));

        int currentRound = 3;

        RacingGameRound racingGameRound = new RacingGameRound(totalRound, currentRound);
        RacingGameInfo racingGameInfo = new RacingGameInfo(cars, racingGameRound);

        // when
        racingGameInfo.initialize();

        // then
        RacingGameRound initializedRacingGameRound = racingGameInfo.getRacingGameRound();

        assertThat(initializedRacingGameRound.getCurrentRound()).isEqualTo(1);
        assertThat(initializedRacingGameRound.getTotalRound()).isEqualTo(totalRound);

        List<Car> initializedCars = racingGameInfo.getCars();

        assertThat(initializedCars.stream().map(Car::getName))
                .containsExactlyElementsOf(carNames);
        initializedCars.forEach(car ->
                assertThat(car.getMovedDistance()).isEqualTo(0)
        );
    }
}
