package test.ch01.step2;

import ch01.step2.InputView;
import ch01.step2.RacingGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    RacingGame racingGame;
    
    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }
    
    @Test
    @DisplayName("Random 숫자 나오는지 확인")
    void getRandomNumberTest(){
        int randomNumber = racingGame.getRandomNumber();
//        assertThat(randomNumber).has(0,1,2,3,4,5,6,7,8,9);
        assertThat(randomNumber).isBetween(0,9);
    }
    
    
    @Test
    void execute() {
        InputView iv = new InputView();

    }
}