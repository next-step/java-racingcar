package test.ch01.step2;

import ch01.step2.InputView;
import ch01.step2.RacingGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @ParameterizedTest
    @DisplayName("숫자 입력받아서 전진할것인지 결정하는 method")
    @CsvSource(value = {"1:false", "2:false", "3:false","4:true","5:true"}, delimiter = ':')
    void isKeepGoingTest(int inputNum,boolean expect){
        racingGame.isKeepGoing(inputNum);
        assertThat(racingGame.isKeepGoing(inputNum)).isEqualTo(expect);
    }

    @Test
    @DisplayName("Random 숫자 나오는지 확인")
    void getRandomNumberTest(){
        int randomNumber = racingGame.getRandomNumber();
        assertThat(randomNumber).isBetween(0,9);
    }
    
    
    @Test
    void execute() {
        InputView iv = new InputView();

    }
}