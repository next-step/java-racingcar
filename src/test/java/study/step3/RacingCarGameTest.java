package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    RacingCarGame racingCarGame;
    RacingCar racingCar;
    InputView inputView;

    @BeforeEach
    void setup(){
        racingCarGame = new RacingCarGame();
        racingCar = new RacingCar();
        inputView = new InputView();
    }

    @Test
    void getRandomNumber(){
        assertThat(racingCar.getRandomNumber()).isLessThan(10);
        assertThat(racingCar.getRandomNumber()).isLessThanOrEqualTo(9);
        assertThat(racingCar.getRandomNumber()).isGreaterThan(-1);
        assertThat(racingCar.getRandomNumber()).isGreaterThanOrEqualTo(0);
    }

    @Test
    void movePossible(){
        assertThat(racingCar.movePossible(4)).isEqualTo(true);
        assertThat(racingCar.movePossible(9)).isEqualTo(true);
        assertThat(racingCar.movePossible(0)).isEqualTo(false);
        assertThat(racingCar.movePossible(2)).isEqualTo(false);
    }

    @Test
    void carMove(){
        racingCar.carMove();
        assertThat(racingCar.getPosition()).isEqualTo(1);
        racingCar.carMove();
        assertThat(racingCar.getPosition()).isEqualTo(2);
    }
}
