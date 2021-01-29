package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("자동차 게임을 테스트한다")
    @Test
    public void createTest(){
        RacingGame racingGame = new RacingGame(new ArrayList<String>(){{
            add("hello");
            add("world");
            add("I");
        }}, 10);
        assertThat(racingGame.playAndGetWinners()).isNotNull();
    }
}
