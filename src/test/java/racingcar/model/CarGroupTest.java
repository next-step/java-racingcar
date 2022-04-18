package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarGroupTest {

    @Test
    void createCars_자동차그룹의_자동차_갯수가_같다() {
        List<String> carNames = List.of("wu2ee", "pobi");
        List<Car> cars = CarGroup.createCars(carNames);
        assertThat(cars).hasSize(2);
    }

    @Test
    void moveCarGroup_모든_자동차가_움직인다() {
        List<String> carNames = List.of("wu2ee", "pobi", "crong", "honux");
        List<Car> cars = CarGroup.createCars(carNames);
        CarGroup carGroup = new CarGroup(cars);

        carGroup.moveCarGroup(new PositiveNumber(5), () -> 4);
        assertThat(cars.stream().map(car -> car.getMoveDistance().getNumber()).collect(Collectors.toList())).containsExactly(5, 5, 5, 5);
    }

    @Test
    void moveCarGroup_모든_자동차가_움직이지_않는다() {
        List<String> carNames = List.of("wu2ee", "pobi", "crong", "honux", "gulb", "kash");
        List<Car> cars = CarGroup.createCars(carNames);
        CarGroup carGroup = new CarGroup(cars);

        carGroup.moveCarGroup(new PositiveNumber(5), () -> 3);
        assertThat(cars.stream().map(car -> car.getMoveDistance().getNumber()).collect(Collectors.toList())).containsExactly(0, 0, 0, 0, 0, 0);
    }

    @Test
    void moveCarGroup_시도한_횟수만큼_이동한다() {
        List<String> carNames = List.of("wu2ee", "pobi", "crong", "honux", "gulb", "kash");
        List<Car> cars = CarGroup.createCars(carNames);
        CarGroup carGroup = new CarGroup(cars);

        carGroup.moveCarGroup(new PositiveNumber(5), () -> 3);
        List<Integer> trialSizes = cars.stream().map(car -> car.getMoveDistanceTrace().size()).collect(Collectors.toList());
        assertThat(trialSizes.stream().reduce((x, y) -> x+y).get()).isEqualTo(5 * 6);
    }

    @Test
    void getWinners_우승자가_존재한다() {
        List<Car> cars = List.of(
                new Car(3, "wu2ee"),
                new Car(5, "pobi"),
                new Car(7, "honux"));

        CarGroup carGroup = new CarGroup(cars);
        assertThat(carGroup.getWinners().get(0).getIdentity()).isEqualTo("honux");
    }

    @Test
    void getWinners_우승자가_여러명_존재한다() {
        List<Car> cars = List.of(
                new Car(3, "wu2ee"),
                new Car(7, "pobi"),
                new Car(7, "honux"));

        CarGroup carGroup = new CarGroup(cars);
        assertThat(carGroup.getWinners().stream().map(Identity::getIdentity).collect(Collectors.toList())).contains("honux","pobi");
    }
}