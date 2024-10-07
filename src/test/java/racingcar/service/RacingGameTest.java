package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.service.dto.GameResult;
import racingcar.service.dto.RacingCarRecord;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("자동차 경주 진행")
    void 자동차_경주_진행() {
        RacingCar pobiCar = new RacingCar("pobi", 5);
        int matchCount = 5;
        List<RacingCar> racingCars = List.of(pobiCar);
        List<GameResult> race = RacingGame.getInstance().race(matchCount, racingCars);
        assertThat(race.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 경주 우승자 찾기")
    void 우승자_선별() {
        RacingCar pobiCar = new RacingCar("pobi", 5);
        RacingCar crongCar = new RacingCar("crong", 3);
        RacingCar honuxCar = new RacingCar("honux", 5);
        List<String> winners = RacingGame.getInstance().findWinners(Arrays.asList(pobiCar, crongCar, honuxCar));
        assertThat(winners).hasSize(2);
        assertThat(winners).isEqualTo(Arrays.asList("pobi", "honux"));
    }

    @Test
    @DisplayName("자동차 대수에 맞게 초기화한다.")
    void 자동차_초기화() {
        List<RacingCar> racingCars = RacingGame.getInstance().createRacingCars("pobi,crong,honux");
        assertThat(racingCars).hasSize(3);
    }

    @Test
    @DisplayName("자동차의 이름과 위치를 전달한다.")
    void 자동차_상태_전달() {
        List<RacingCar> racingCars = RacingGame.getInstance().createRacingCars("pobi,crong");
        RacingCarRecord pobiCar = new RacingCarRecord("pobi", 1);
        RacingCarRecord crongCar = new RacingCarRecord("crong", 1);
        assertThat(RacingGame.getInstance().getRacingCarsPosition(racingCars)).isEqualTo(new GameResult(Arrays.asList(pobiCar, crongCar)));
    }
}
