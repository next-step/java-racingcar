package CarRacing;

import StringCalculator.ArithmeticExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingTest {

    @Test
    @DisplayName("Random Value Test")
    public void randomValueTest() {
       assertThat(RandomValue.getRandomValue()).isBetween(0,9);
    }

    @Test
    @DisplayName("CarRacing Test")
    public void carRacingTest() {
        int carCount = 2;
        int gameCount = 2;
        CarRacingOption carRacingOption = new CarRacingOption(carCount, gameCount);
        CarRacingGame carRacingGame = new CarRacingGame(carRacingOption);
        carRacingGame.gameInit();
        carRacingGame.gameStart();
    }
}
