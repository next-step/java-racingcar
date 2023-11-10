package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racing.type.CarName;
import racing.type.Position;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

public class RacingGameLogicTest {
    @Test
    @DisplayName("지정된 횟수만큼의 사이클 진행")
    public void specifiedCycles() {
        final int theNumberOfCycles = 5;
        final int theNumberOfCars = 3; // 이 변수는 테스트에 영향을 미치지 않음.

        RacingGameState state = RacingGameLogic.init(theNumberOfCars, theNumberOfCycles);

        for (int i = 0; i <theNumberOfCycles-1; i++) {
            state = RacingGameLogic.update(state);
            assertThat(RacingGameLogic.isGameOver(state)).isFalse();
        }

        state = RacingGameLogic.update(state);
        assertThat(RacingGameLogic.isGameOver(state)).isTrue();
    }

    @Test
    @DisplayName("[RacingGameLogic.getWinnerNames] 현 게임 상태 주면 -> 이기고 있는 사람 목록 반환")
    public void getWinnerNames() {
        Car carA = Car.create(new CarName("carA"), new Position(4));
        Car carB = Car.create(new CarName("carB"), new Position(2));
        Car carC = Car.create(new CarName("carC"), new Position(4));

        RacingGameState state = RacingGameState.createNewGame(
                List.of(carA, carB, carC),
                5
        );

        assertThat(RacingGameLogic.getWinnerList(state))
                .hasSameElementsAs(
                        List.of(carA, carC)
                );
    }
}
