package racingGame.business;

import static org.assertj.core.api.Assertions.*;
import static racingGame.business.CarFactory.createCars;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.model.ProgressRecord;
import racingGame.model.GameResult;
import racingGame.model.Car;

import java.util.List;

class GameMoveTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void moveSetTest(int num) {
        assertThatThrownBy(() -> {
            new GameMove(num);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%s", "이동횟수에 입력이 생략되거나, 0이하");
    }

    @Test
    void ruesSetTest() {
        assertThat(new GameMove(5)).isNotNull();
    }

    @Test
    void moveCountTest() {
        int moveCount = 5;
        String[] strings = {"pobi", "crong","honux"};
        GameMove gameMove = new GameMove(moveCount);
        List<Car> cars = createCars(strings);
        GameResult gameResult = gameMove.moveCar(cars);
        
        assertThat(gameResult.progressRecords())
            .allSatisfy(ProgressRecord::joinCars).hasSize(moveCount);
    }
    
    @Test
    void CarCountTest() {
        int moveCount = 5;
        String[] strings = {"pobi", "crong","honux"};
        GameMove gameMove = new GameMove(moveCount);
        List<Car> cars = createCars(strings);
        GameResult gameResult = gameMove.moveCar(cars);
        
        assertThat(gameResult.progressRecords())
            .allSatisfy(progressRecord ->
                assertThat(progressRecord.joinCars()).hasSize(strings.length)
        );
    }

}