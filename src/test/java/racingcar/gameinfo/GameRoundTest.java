package racingcar.gameinfo;

import racingcar.car.Car;
import racingcar.car.CarCreator;
import java.util.List;

import racingcar.moverule.RandomMoveRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.mockito.Mockito.*;

public class GameRoundTest {

    RandomMoveRule moveRule = mock(RandomMoveRule.class);

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("자동차 수에 맞게 move 함수가 호출되는지 테스트")
    void moveVerifyTest(int carCount) {
        List<Car> carList = CarCreator.create(carCount);
        new RacingCarGameRound(moveRule).play(carList);
        verify(moveRule,times(carCount)).move(any());
    }
}