package racingcar.domain;

import org.junit.Test;
import racingcar.random.CarMoveThresholdGenerator;
import racingcar.random.IntMoreThanCarMoveThresholdGenerator;
import racingcar.random.RandomIntGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGroupTest {
    private List<String> carNames = Arrays.asList("pobi", "crong", "honux");

    @Test
    public void 항상_전진하는_자동차_그룹() {
        // given
        RandomIntGenerator randomIntGenerator = new IntMoreThanCarMoveThresholdGenerator();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        RacingCarGroup racingCarGroup = new RacingCarGroup(cars, randomIntGenerator);

        // when
        racingCarGroup.go();

        // then
        List<Car> carsOfGroup = racingCarGroup.getCars();

        carsOfGroup.forEach(car ->
                assertThat(car.getMovedDistance()).isEqualTo(1)
        );
    }

    @Test
    public void 전진하지_않는_자동차_그룹() {
        // given
        RandomIntGenerator randomIntGenerator = new CarMoveThresholdGenerator();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        RacingCarGroup racingCarGroup = new RacingCarGroup(cars, randomIntGenerator);

        // when
        racingCarGroup.go();

        // then
        List<Car> carsOfGroup = racingCarGroup.getCars();

        carsOfGroup.forEach(car ->
                assertThat(car.getMovedDistance()).isEqualTo(0)
        );
    }

    @Test
    public void 초기화() {
        // given
        List<Car> cars = carNames.stream()
                .map(name -> new Car(name, 3))
                .collect(Collectors.toList());
        RacingCarGroup racingCarGroup = new RacingCarGroup(cars);

        // when
        racingCarGroup.initialize();

        // then
        racingCarGroup.getCars().forEach(car ->
                assertThat(car.getMovedDistance()).isEqualTo(0)
        );
    }
}
