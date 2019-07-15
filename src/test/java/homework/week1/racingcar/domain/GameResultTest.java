package homework.week1.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameResultTest {
    private GameResult result;
    @BeforeEach
    void setUp() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 1));
        cars.add(new Car("crong", 2));
        cars.add(new Car("honux", 3));
        cars.add(new Car("jk", 3));
        result = GameResult.of(cars);
    }

    @Test
    void getMaxPosition() {
        assertThat(result.getMaxPosition()).isEqualTo(3);
    }

    @Test
    void getWinnerNames() {
        List<String> winnerNames = result.getWinnerNames(result.getMaxPosition());
        assertThat(winnerNames).containsExactly("honux", "jk");
    }

    @Test
    void getResultCars_unmodifiable() {
        assertThrows(UnsupportedOperationException.class, () -> {
            result.getResultCars().add(new Car("test1", 4));
            result.getResultCars().add(0, new Car("test2", 4));
        });
    }
}
