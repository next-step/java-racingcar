package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

public class RacingGameTest {
    @Test
    @DisplayName("한 사이클 진행")
    public void oneCycle() {
        Car mySpringCar = Mockito.mock(Car.class);
        Car mySummerCar = Mockito.mock(Car.class);

        RacingGame racingGame = RacingGame.createRacingGame(List.of(mySpringCar, mySummerCar), 5);
        racingGame.update();

        verify(mySpringCar).go();
        verify(mySummerCar).go();
    }

    @Test
    @DisplayName("지정된 횟수만큼의 사이클 진행")
    public void specifiedCycles() {
        RacingGame racingGame = RacingGame.createRacingGame(3, 5);

        //첫 4번은 stopFlag가 False, 마지막 5회 째는 true
        assertThat(racingGame.update()).isFalse();
        assertThat(racingGame.update()).isFalse();
        assertThat(racingGame.update()).isFalse();
        assertThat(racingGame.update()).isFalse();
        assertThat(racingGame.update()).isTrue();
    }
}
