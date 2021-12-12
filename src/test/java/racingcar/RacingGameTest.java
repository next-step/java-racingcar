package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Position;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingResult;
import racingcar.domain.movingstrategy.AlwayStopStrategy;
import racingcar.domain.movingstrategy.AlwaysGoStrategy;
import racingcar.domain.movingstrategy.MovingStrategy;
import racingcar.domain.movingstrategy.RandomMovingStrategy;
import racingcar.exception.RacingGameException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class RacingGameTest {

    @Test
    @DisplayName("start 테스트: 등록된 차량이 없으면 시작할 수 없다.")
    void start1() {
        RacingGame racingGame = new RacingGame(2);

        assertThrows(RacingGameException.class, racingGame::start);
    }

    @Test
    @DisplayName("start 테스트: 종료된 레이스는 다시 시작할 수 없다.")
    void start2() {
        RacingGame racingGame = new RacingGame(2);
        racingGame.registerCar(new RacingCar(RandomMovingStrategy.getInatance()));
        racingGame.registerCar(new RacingCar(RandomMovingStrategy.getInatance()));

        racingGame.start();

        assertThrows(RacingGameException.class, racingGame::start);
    }


    @Test
    @DisplayName("start 테스트: 레이싱 결과를 담은 RacingResult가 리턴된다.")
    void start3() {
        int labCount = 3;

        MovingStrategy alwaysGoStrategy = new AlwaysGoStrategy();
        MovingStrategy alwaysStopStrategy = new AlwayStopStrategy();

        RacingCar car1 = new RacingCar(alwaysGoStrategy);
        RacingCar car2 = new RacingCar(alwaysStopStrategy);

        RacingGame racingGame = new RacingGame(labCount);
        racingGame.registerCar(car1);
        racingGame.registerCar(car2);

        RacingResult racingResult = racingGame.start();

        assertEquals(racingResult.getRecords().size(), labCount);

        assertEquals(racingResult.getRecords().get(0).getRacingCars().get(0).getPosition(), new Position(1));
        assertEquals(racingResult.getRecords().get(0).getRacingCars().get(1).getPosition(), new Position(0));

        assertEquals(racingResult.getRecords().get(1).getRacingCars().get(0).getPosition(), new Position(2));
        assertEquals(racingResult.getRecords().get(1).getRacingCars().get(1).getPosition(), new Position(0));
    }

    @Test
    @DisplayName("registerCar 테스트: 종료된 레이스에는 차량을 추가할 수 없다.")
    void registerCar() {
        RacingGame racingGame = new RacingGame(2);
        racingGame.registerCar(new RacingCar(RandomMovingStrategy.getInatance()));
        racingGame.registerCar(new RacingCar(RandomMovingStrategy.getInatance()));

        racingGame.start();

        assertThrows(RacingGameException.class, () -> racingGame.registerCar(new RacingCar(RandomMovingStrategy.getInatance())));
    }

    @ParameterizedTest
    @DisplayName("registerCar 테스트: 설정 된 lab만큼 각 차량의 move가 호출되어야 한다.")
    @ValueSource(ints = {1, 3, 5, 2, 8})
    void registerCar(int labCount) {
        RacingCar car1 = new RacingCar(new AlwaysGoStrategy());

        RacingGame racingGame = new RacingGame(labCount);
        racingGame.registerCar(car1);
        racingGame.start();

        assertEquals(new Position(labCount), car1.getPosition());
    }

}
