package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PowerSupply;

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
        final int initialPosition = 5;
        Car car = TestObjectGenerator.generateCar("a", initialPosition);
        Car movedCar = TestObjectGenerator.generateCar("a", initialPosition + 1);
        final int carCount = 3;
        Cars cars = TestObjectGenerator.generateCars(car, carCount);
        Cars movedCars = TestObjectGenerator.generateCars(movedCar, carCount);
        PowerSupply powerSupply = TestObjectGenerator.generateMovablePowerSupply();

        //when
        Cars result = cars.moveCarsRandomly(powerSupply);

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
    @DisplayName("자동차들의 이름이 모두 String 으로 반환돼야 한다")
    void namesAsString() {
        //given
        List<CarName> carNames = TestObjectGenerator.generateCarNames();
        List<String> carNamesAsString = carNames.stream()
                .map(CarName::toString)
                .collect(Collectors.toList());
        Cars cars = Cars.fromCarNames(carNames);

        //when
        List<String> result = cars.namesAsString();

        //then
        assertThat(result.size()).isEqualTo(carNames.size());
        assertThat(result).containsAll(carNamesAsString);
    }
}