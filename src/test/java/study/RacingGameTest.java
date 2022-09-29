package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {


    @Test
    @DisplayName("생성된 자동차의 개수")
    void carCount(){
        RacingGame racingGame = new RacingGame();
        assertThat(racingGame.makeCarList(5)).hasSize(5);
    }
}
