package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {


    @Test
    @DisplayName("한 사이클 진행")
    public void oneCycle() {
        Car mySpringCar = Mockito.mock(Car.class);
        Car mySummerCar = Mockito.mock(Car.class);

        RacingGame racingGame = new RacingGame(List.of(mySpringCar, mySummerCar));
        racingGame.doACycle();

        Mockito.verify(mySpringCar).go();
        Mockito.verify(mySummerCar).go();
    }
}
