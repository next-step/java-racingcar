package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    RacingCarGame racingCarGame;
    InputView inputView;

    @BeforeEach
    void setup(){
        racingCarGame = new RacingCarGame();
        inputView = new InputView();
    }

    @Test
    void getRandomNumber(){
        assertThat(racingCarGame.getRandomNumber()).isLessThan(10);
        assertThat(racingCarGame.getRandomNumber()).isLessThanOrEqualTo(9);
        assertThat(racingCarGame.getRandomNumber()).isGreaterThan(-1);
        assertThat(racingCarGame.getRandomNumber()).isGreaterThanOrEqualTo(0);
    }

    @Test
    void movePossible(){
        assertThat(racingCarGame.movePossible(4)).isEqualTo(true);
        assertThat(racingCarGame.movePossible(9)).isEqualTo(true);
        assertThat(racingCarGame.movePossible(0)).isEqualTo(false);
        assertThat(racingCarGame.movePossible(2)).isEqualTo(false);
    }
}
