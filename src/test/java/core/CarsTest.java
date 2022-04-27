package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    @DisplayName("carName 이 carNames 로 구성된 Car 들이 만들어져야 한다")
    void fromCarNames() {
        //given
        CarName carName1 = CarName.create("abc");
        CarName carName2 = CarName.create("bcd");
        CarName carName3 = CarName.create("cde");
        List<CarName> carNames = new ArrayList<>(Arrays.asList(carName1, carName2, carName3));

        //when
        Cars result = Cars.fromCarNames(carNames);

        //then
        assertThat(carNames.size()).isEqualTo(result.getCars().size());
        assertThat(result.names()).containsAll(carNames);
    }

    @Test
    @DisplayName("모든 Car 의 move 가 한번씩 실행돼야 한다")
    void moveCarsRandomly() {
        //given
        final int carCount = 3;
        Cars cars = TestObjectGenerator.generateCars(carCount);
        List<Car> movedCarList = new ArrayList<>();
        for (Car car : cars.getCars()) {
            movedCarList.add(car.move(Car.BASE_MOVE_VALUE));
        }
        Cars movedCars = Cars.fromCars(movedCarList);
        PowerSupply powerSupply = TestObjectGenerator.generateMovablePowerSupply();

        //when
        Cars result = cars.moveBy(powerSupply);

        //then
        assertThat(result).isEqualTo(movedCars);
    }

    @Test
    @DisplayName("자동차들의 이름이 모두 반환돼야 한다")
    void names() {
        //given
        List<CarName> carNames = TestObjectGenerator.generateCarNames();
        Cars cars = Cars.fromCarNames(carNames);

        //when
        List<CarName> result = cars.names();

        //then
        assertThat(result.size()).isEqualTo(carNames.size());
        assertThat(result).containsAll(carNames);
    }

    @Test
    @DisplayName("자동차들의 id 가 모두 반환돼야 한다")
    void ids() {
        //given
        Car car1 = TestObjectGenerator.generateCar("a", 0);
        Car car2 = TestObjectGenerator.generateCar("b", 0);
        Car car3 = TestObjectGenerator.generateCar("c", 0);
        List<Car> carList = Arrays.asList(car1, car2, car3);
        Cars cars = Cars.fromCars(carList);
        List<String> ids = carList.stream()
                .map(Car::getId)
                .collect(Collectors.toList());

        //when
        List<String> result = cars.ids();

        //then
        assertThat(result.size()).isEqualTo(ids.size());
        assertThat(result).containsAll(ids);
    }

    @Test
    @DisplayName("id 에 해당하는 자동차의 이름을 반환한다")
    void findCarNameById() {
        //given
        List<CarName> carNames = TestObjectGenerator.generateCarNames();
        Cars cars = Cars.fromCarNames(carNames);
        Car car = cars.getCars().stream()
                .findAny()
                .orElseThrow(RuntimeException::new);

        //when
        CarName result = cars.findCarNameById(car.getId());

        //then
        assertThat(result).isEqualTo(car.getCarName());
    }
}