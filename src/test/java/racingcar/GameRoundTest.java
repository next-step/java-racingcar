package racingcar;

import car.Car;
import car.CarCreator;
import java.util.List;

import moverule.RandomMoveRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GameRoundTest {

    RandomMoveRule moveRule = mock(RandomMoveRule.class);

    @Test
    @DisplayName("for문 loop carlist맞춰 도는지 확인")
    void moveVerifyTest(){
        int size = 10;
        List<Car> carList = CarCreator.create(size);
        GameRound.play(carList,moveRule);
        verify(moveRule,times(size)).move(any());
    }
}
