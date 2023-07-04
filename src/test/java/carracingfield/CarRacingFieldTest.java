package carracingfield;

import static org.assertj.core.api.Assertions.assertThat;

import car.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import winnerstrategy.MaxPositionDuplicateWinnerStrategy;

public class CarRacingFieldTest {

    CarRacingField field;

    @BeforeEach
    void setup() {
        field = new CarRacingField(
            List.of("a", "b", "c"),
            new MaxPositionDuplicateWinnerStrategy()
        );
    }

    @Test
    @DisplayName("레이싱 필드에서 자동차들을 이동시키면 모든 자동차가 움직이지 않거나 1칸 이동한다.")
    void test1() {
        List<Car> cars = field.getCars();
        List<Integer> carPrevPositions = cars.stream()
            .map(Car::getPosition)
            .collect(Collectors.toList());

        field.moveCarsByCount(1);

        for (int i = 0; i < cars.size(); i++) {
            int positionDiff = cars.get(i).getPosition() - carPrevPositions.get(i);
            assertThat(positionDiff >= 0).isTrue();
            assertThat(positionDiff <= 1).isTrue();
        }
    }
}
