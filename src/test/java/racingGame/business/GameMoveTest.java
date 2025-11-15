package racingGame.business;

import static org.assertj.core.api.Assertions.*;
import static racingGame.business.CarFactory.createCars;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.model.*;

import java.util.List;

class GameMoveTest {


    @Test
    void ruesSetTest() {
        assertThat(new GameMove(new NonNegativeMoves(5))).isNotNull();
    }

    @Test
    void moveCountTest() {
        int moveCount = 5;
        String[] strings = {"pobi", "crong","honux"};
        GameMove gameMove = new GameMove((new NonNegativeMoves(moveCount)));
        List<Car> cars = createCars(new NonNegativeReadyCars(strings));
        GameResult gameResult = gameMove.moveCar(cars);
        
        assertThat(gameResult.progressRecords())
            .allSatisfy(ProgressRecord::joinCars).hasSize(moveCount);
    }
    
    @Test
    void CarCountTest() {
        int moveCount = 5;
        String[] strings = {"pobi", "crong","honux"};
        GameMove gameMove = new GameMove((new NonNegativeMoves(moveCount)));
        List<Car> cars = createCars(new NonNegativeReadyCars(strings));
        GameResult gameResult = gameMove.moveCar(cars);
        
        assertThat(gameResult.progressRecords())
            .allSatisfy(progressRecord ->
                assertThat(progressRecord.joinCars()).hasSize(strings.length)
        );
    }

}