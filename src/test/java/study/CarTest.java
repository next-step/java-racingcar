package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.RacingCarGame;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void racing(){
        String[] carNames = "aa,bb,cc,dd".split(",");
        int numTry = 6;
        RacingCarGame carGame = new RacingCarGame(carNames, numTry);
        carGame.start();
    }

    @DisplayName("테스트 ")
    @Test
    void racing2(){
        String[] carNames = "aa,bb,cc,dd".split(",");
        int numTry = 6;
        RacingCarGame carGame = new RacingCarGame(carNames, numTry);
        carGame.start();
    }
}



