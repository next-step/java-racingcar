package racingcar;

import org.junit.Ignore;
import org.junit.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.RacingResult;
import racingcar.view.WinnerUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class WinnerUtilsTest {
    static final int MOVEABLE_RANDOMNUM = 4;
    static final int NONE_MOVEABLE_RANDOMNUM = 1;

    @Test
    public void 자동차_우승자_리스트_1명() {
        List<Car> cars = RacingGame.setupCar("가가,나나,다다");
        cars.get(0).move(NONE_MOVEABLE_RANDOMNUM);
        cars.get(1).move(NONE_MOVEABLE_RANDOMNUM);
        cars.get(2).move(MOVEABLE_RANDOMNUM);
        RacingResult racingResult = new RacingResult(cars);
        List<Car> winners = WinnerUtils.topRankSearch(racingResult);
        assertThat(winners.size()).isEqualTo(1);
    }

    @Test
    public void 자동차_우승자_리스트_2명() {
        List<Car> cars = RacingGame.setupCar("가가,나나,다다");
        cars.get(0).move(NONE_MOVEABLE_RANDOMNUM);
        cars.get(1).move(MOVEABLE_RANDOMNUM);
        cars.get(2).move(MOVEABLE_RANDOMNUM);
        RacingResult racingResult = new RacingResult(cars);
        List<Car> winners = WinnerUtils.topRankSearch(racingResult);
        assertThat(winners.size()).isEqualTo(2);
    }



}