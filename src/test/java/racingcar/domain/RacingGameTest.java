package racingcar.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    // 여기는 테스트코드 어떻게 짤지 잘 모르겠어요;;
    @Test
    public void 한라운드_진행() {
        RacingGame racingGame = new RacingGame(new String[]{"test1", "test2"}, 1);
        List<Car> result = racingGame.playRound();
        //assertThat(result).is
    }

}
