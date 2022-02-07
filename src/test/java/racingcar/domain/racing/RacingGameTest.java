package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Participants;
import racingcar.domain.car.Turn;

class RacingGameTest {

    @Test
    public void 최종_우승자_단독() {
        //given
        List<Car> cars = Arrays.asList(new Car("jason", 3), new Car("pobi", 2), new Car("sung", 1));
        RacingGame racingGame = new RacingGame(new Participants(cars), new Turn("2"), (() -> 5));

        //when
        List<Participants> racingResult = racingGame.start();

        //then
        assertThat(racingGame.findWinners(racingResult)).isEqualTo("jason");
    }

    @Test
    public void 최종_우승자_공동() {
        //given
        List<Car> cars = Arrays.asList(new Car("jason", 3), new Car("pobi", 2), new Car("sung", 3));
        RacingGame racingGame = new RacingGame(new Participants(cars), new Turn("2"), (() -> 5));

        //when
        List<Participants> racingResult = racingGame.start();

        //then
        assertThat(racingGame.findWinners(racingResult)).isEqualTo("jason, sung");
    }
}