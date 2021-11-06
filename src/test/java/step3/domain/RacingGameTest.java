package step3.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @Test
    void 경주_게임을_생성한다() {
        //given
        RacingGame racingGame = RacingGame.create(0, null);
        //when & then
        assertThat(racingGame).isNotNull();
    }

    @Test
    void 경주를_시작한다() {
        //given
        List<Car> cars = Arrays.asList(Car.create(), Car.create(), Car.create());
        //when
        RacingGame racingGame = RacingGame.create(3, cars);
        racingGame.start();
        //then
    }

    @Test
    void 시도_회수가_0이하면_IllegalArgumentException이_발생한다() {
        //given
        RacingGame racingGame = RacingGame.create(0, Arrays.asList(Car.create()));
        //when & then
        assertThatThrownBy(racingGame::start)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 경주에_참여할_자동차_수가_0이면_IllegalArgumentException이_발생한다() {
        //given
        RacingGame racingGame = RacingGame.create(3, new ArrayList<>());
        //when & then
        assertThatThrownBy(racingGame::start)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
