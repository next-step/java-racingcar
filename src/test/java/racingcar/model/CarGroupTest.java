package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarGroupTest {


    @Test
    void createCars_자동차그룹의_자동차_갯수가_같다() {
        List<Car> cars = CarGroup.createCars(new PositiveNumber(3));
        assertThat(cars).hasSize(3);
    }

    @Test
    void moveCarGroup_모든_자동차가_움직인다() {
        List<Car> cars = CarGroup.createCars(new PositiveNumber(4));
        CarGroup carGroup = new CarGroup(cars);

        carGroup.moveCarGroup(new PositiveNumber(5), () -> 4);
        assertThat(cars.stream().map(car -> car.getMoveDistance().getNumber()).collect(Collectors.toList())).containsExactly(5, 5, 5, 5);
    }

    @Test
    void moveCarGroup_모든_자동차가_움직이지_않는다() {
        List<Car> cars = CarGroup.createCars(new PositiveNumber(6));
        CarGroup carGroup = new CarGroup(cars);

        carGroup.moveCarGroup(new PositiveNumber(5), () -> 3);
        assertThat(cars.stream().map(car -> car.getMoveDistance().getNumber()).collect(Collectors.toList())).containsExactly(0, 0, 0, 0, 0, 0);
    }

    @Test
    void moveCarGroup_시도한_횟수만큼_이동한다() {
        List<Car> cars = CarGroup.createCars(new PositiveNumber(6));
        CarGroup carGroup = new CarGroup(cars);

        carGroup.moveCarGroup(new PositiveNumber(5), () -> 3);
        List<Integer> trialSizes = cars.stream().map(car -> car.getMoveDistanceTrace().size()).collect(Collectors.toList());
        assertThat(trialSizes.stream().reduce((x, y) -> x+y).get()).isEqualTo(5 * 6);
    }

}