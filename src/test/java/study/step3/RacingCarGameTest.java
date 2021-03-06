package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    RacingCarGame racingCarGame;
    RacingCar racingCar;
    RandomGenerator randomGenerator;

    @BeforeEach
    void setup(){
        racingCarGame = new RacingCarGame();
        racingCar = new RacingCar();
        randomGenerator = new RandomGenerator();
    }

    @Test
    void getRandomNumber(){
        assertThat(randomGenerator.getRandomNumber()).isLessThan(10);
        assertThat(randomGenerator.getRandomNumber()).isLessThanOrEqualTo(9);
        assertThat(randomGenerator.getRandomNumber()).isGreaterThan(-1);
        assertThat(randomGenerator.getRandomNumber()).isGreaterThanOrEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "4:true", "3:false", "9:true", "0:false"}, delimiter = ':')
    void movePossible(Integer number, boolean expected){
        assertThat(racingCar.movePossible(number)).isEqualTo(expected);
    }

    @Test
    void carMove(){
        for (int i = 1; i <= 10; i ++) {
            racingCar.carMove();
            assertThat(racingCar.getPosition()).isEqualTo(i);
        }
    }
}
