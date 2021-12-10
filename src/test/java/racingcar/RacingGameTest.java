package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.broadcast.Broadcast;
import racingcar.exception.RacingGameException;
import racingcar.movingstrategy.RandomMovingStrategy;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class RacingGameTest {

    @Test
    @DisplayName("start 테스트: 등록된 차량이 없으면 시작할 수 없다.")
    void start1() {
        RacingGame racingGame = new RacingGame(2, mock(Broadcast.class));

        Assertions.assertThrows(RacingGameException.class, racingGame::start);
    }

    @Test
    @DisplayName("start 테스트: 종료된 레이스는 다시 시작할 수 없다.")
    void start2() {
        RacingGame racingGame = new RacingGame(2, mock(Broadcast.class));
        racingGame.registerCar(new RacingCar(RandomMovingStrategy.getInatance()));
        racingGame.registerCar(new RacingCar(RandomMovingStrategy.getInatance()));

        racingGame.start();

        Assertions.assertThrows(RacingGameException.class, racingGame::start);
    }

    @ParameterizedTest
    @DisplayName("registerCar 테스트: 설정 된 lab만큼 각 차량의 move가 호출되어야 한다.")
    @ValueSource(ints = {1, 3, 5, 2, 8})
    void start3(int labCount) {
        RacingCar car1 = mock(RacingCar.class);
        RacingCar car2 = mock(RacingCar.class);
        RacingCar car3 = mock(RacingCar.class);

        RacingGame racingGame = new RacingGame(labCount, mock(Broadcast.class));
        racingGame.registerCar(car1);
        racingGame.registerCar(car2);
        racingGame.registerCar(car3);

        when(car1.move()).thenReturn(new Position(0));
        when(car2.move()).thenReturn(new Position(0));
        when(car3.move()).thenReturn(new Position(0));

        racingGame.start();

        verify(car1, times(labCount)).move();
        verify(car2, times(labCount)).move();
        verify(car3, times(labCount)).move();
    }

    @Test
    @DisplayName("registerCar 테스트: 종료된 레이스에는 차량을 추가할 수 없다.")
    void registerCar() {
        RacingGame racingGame = new RacingGame(2, mock(Broadcast.class));
        racingGame.registerCar(new RacingCar(RandomMovingStrategy.getInatance()));
        racingGame.registerCar(new RacingCar(RandomMovingStrategy.getInatance()));

        racingGame.start();

        Assertions.assertThrows(RacingGameException.class, () -> racingGame.registerCar(mock(RacingCar.class)));
    }

}
