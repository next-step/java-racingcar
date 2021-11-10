package step3.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void 경주_게임을_생성한다() {
        //given
        String names = "java,c++,go";
        //when
        RacingGame racingGame = RacingGame.create(3, names);
        //then
        assertThat(racingGame).isNotNull();
    }

    @Test
    void 경주를_시작한다() {
        //given
        String names = "java,c++,go";
        //when
        RacingGame racingGame = RacingGame.create(3, names);
        //then
        racingGame.start();
    }
}
