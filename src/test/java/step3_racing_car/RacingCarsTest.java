package step3_racing_car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3_racing_car.domain.Position;
import step3_racing_car.domain.RacingCar;
import step3_racing_car.domain.RacingCars;
import step3_racing_car.strategy.ForwardStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarsTest {
    @Test
    @DisplayName("ForwardStrategy에서 각 경주 차들이 1칸씩 이동하는지 확인한다.")
    void move() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("자동차1"));
        cars.add(new RacingCar("자동차2"));
        cars.add(new RacingCar("자동차3"));

        RacingCars racingCars = new RacingCars(cars);
        racingCars.movePosition(new ForwardStrategy());

        for (RacingCar car : racingCars.getItems()) {
            assertThat(car.getPosition())
                    .usingRecursiveComparison()
                    .isEqualTo(new Position(1));
        }
    }

    @Test
    @DisplayName("경주차들의 최대 이동 거리를 확인한다.")
    void maxPosition() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("자동차1", 4));
        cars.add(new RacingCar("자동차2", 3));
        cars.add(new RacingCar("자동차3", 5));

        assertThat(new RacingCars(cars).maxPositionValue()).isEqualTo(5);
    }

    @Test
    @DisplayName("이동거리와 일치하는 경주차의 리스트를 잘 가져오는지 확인한다.")
    void matchPositionList() {
        List<RacingCar> cars = new ArrayList<>();
        cars.add(new RacingCar("자동차1", 3));
        cars.add(new RacingCar("자동차2", 5));
        cars.add(new RacingCar("자동차3", 5));

        List<RacingCar> result = new RacingCars(cars).matchPositionList(5);
        assertThat(result)
                .usingRecursiveComparison()
                .isEqualTo(List.of(
                        new RacingCar("자동차2", 5),
                        new RacingCar("자동차3", 5)));
    }
}
