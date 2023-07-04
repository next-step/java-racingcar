package carracingfield;

import static org.assertj.core.api.Assertions.assertThat;

import car.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRacingFieldTest {

    @Test
    @DisplayName("레이싱 필드에서 자동차들을 이동시키면 모든 자동차가 움직이지 않거나 1칸 이동한다.")
    void test1() {
        CarRacingField field = new CarRacingField(List.of("a", "b", "c"));
        List<Car> cars = field.getCars();
        List<Integer> carPrevPositions = cars.stream()
            .map(Car::getPosition)
            .collect(Collectors.toList());

        field.moveCars();

        for (int i = 0; i < cars.size(); i++) {
            int positionDiff = cars.get(i).getPosition() - carPrevPositions.get(i);
            assertThat(positionDiff >= 0).isTrue();
            assertThat(positionDiff <= 1).isTrue();
        }
    }

    @Test
    @DisplayName("position 값이 가장 큰 자동차를 우승자로 선출한다.")
    void test2() {
        CarRacingField field = new CarRacingField(List.of("a", "b", "c"));
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(4, "a"));
        carList.add(new Car(3, "b"));

        List<Car> winners = field.getWinners(carList);
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.stream().map(Car::getName).collect(Collectors.toList()))
            .containsExactly("a");
    }
}
