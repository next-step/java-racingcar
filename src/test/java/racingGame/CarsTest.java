package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.racingRule.FowardRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private FowardRule fowardRule = new FowardRule();

    @Test
    @DisplayName("움직인만큼 -를 join 반환한다.")
    void createTraces(){
        String mark = "-";
        Cars cars = new Cars(List.of(new Car(), new Car(), new Car()));
        cars.getCars().forEach(car -> car.move(fowardRule));
        cars.getCars().forEach(car -> car.move(fowardRule));

        assertThat(cars.getCars().get(0).createTrace(mark)).isEqualTo("--");
    }
}