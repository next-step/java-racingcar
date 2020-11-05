package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;
import racing.domain.Grid;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GridTest {


    @ParameterizedTest
    @CsvSource(value = {
            "1,1",
            "2,2",
            "3,3",
            "100,100"
    })
    @DisplayName("그리드에 준비된 차량의 대수가 같은지 확인")
    public void grid_normal_lineupSize(int cars, int result) {
        List<Car> numberOfCars = new Grid(new LinkedList<>()).lineUp(cars).getStartingGrid();
        assertThat(numberOfCars.size()).isEqualTo(result);
    }
}
