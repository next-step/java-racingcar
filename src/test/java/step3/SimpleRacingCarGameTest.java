package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;
import step3.application.SimpleRacingCarGame;

class SimpleRacingCarGameTest {

    @Test
    void 입력한_자동차_갯수만큼_자동차_생성() {
        int carCnt = 5;
        int round = 3;
        SimpleRacingCarGame game = new SimpleRacingCarGame(carCnt, round);
        assertThat(game.joinCars().size()).isEqualTo(carCnt);
    }

    @Test
    void 자동차_경주_정상_실행() {
        int carCnt = 5;
        int round = 3;
        SimpleRacingCarGame game = new SimpleRacingCarGame(carCnt, round);
        assertThatCode(game::start).doesNotThrowAnyException();
    }
}
