package racingGame.Business;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.model.Car;
import racingGame.model.ProgressRecord;

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
    void moveCarTest() {
        int moveCount = 5;
        String[] strings = {"pobi", "crong","honux"};
        GameMove gameMove = new GameMove(moveCount);
        List<Car> cars = new CarFactory().createCars(strings);
        List<ProgressRecord> progressRecords = gameMove.moveCar(cars);

        assertThat(progressRecords).hasSize(moveCount);
        assertThat(progressRecords)
                .allSatisfy(progressRecord ->
                        assertThat(progressRecord.carRecord()).hasSize(strings.length));
    }

}