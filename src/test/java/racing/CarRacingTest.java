package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Grid;
import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {

    @ParameterizedTest
    @CsvSource(value = {"3:4", "7:3", "5:5", "2:10"}, delimiter = ':')
    @DisplayName("레이싱 결과 차량대수:라운드 수 확인")
    public void carRacing_(int cars, int rounds) {
        Grid grid = new CarRacing(cars,rounds).start();
        assertThat(grid.getStartingGrid().size()).isEqualTo(cars);
        assertThat(grid.getRound()).isEqualTo(rounds);
    }
}
