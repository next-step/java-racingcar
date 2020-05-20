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
       assertThat(new RandomValue().getRandomValue()).isBetween(0,9);
    }

    @Test
    @DisplayName("Random Min Value Test")
    public void randomMinValueTest() {
        assertThat(new RandomMinValue().getRandomValue()).isGreaterThan(4);
    }

    @Test
    @DisplayName("Random Max Value Test")
    public void randomMaxValueTest() {
        assertThat(new RandomMaxValue().getRandomValue()).isLessThan(4);
    }

    @Test
    @DisplayName("CarRacing Test")
    public void carRacingTest() {
        int carCount = 2;
        int gameCount = 2;
        CarRacingOption carRacingOption = new CarRacingOption(carCount, gameCount);
        CarRacingGame carRacingGame = new CarRacingGame(carRacingOption);
        carRacingGame.gameStart();
    }
}
