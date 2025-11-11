package racingGame.Business;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
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
    void moveCarTest() {
        GameMove gameMove = new GameMove(5);
        List<Car> cars = new CarFactory().createCars(3);
        List<Car> carResult = gameMove.moveCar(cars);
        assertThat(carResult.getFirst().findLocation()).isNotEqualTo(0);
    }

}