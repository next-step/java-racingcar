package racingcar.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.model.Cars;

public class RacingGameServiceTest {

    private static final int TRY_COUNT = 5;

    @Test
    @DisplayName("게임 시도 횟수 일치 확인")
    void gameStart() {
        RacingGameService racingGameService = new RacingGameService(Cars.from("kim,dong,hyo"));
        Cars cars = racingGameService.gameStart(TRY_COUNT);
        assertThat(cars.getTryCountTotal()).isEqualTo(TRY_COUNT);
    }
}
