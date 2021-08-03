package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("입력된 차 List가 null이거나 empty일 경우 IllegalArgumentExcpetion 발생")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @NullAndEmptySource
    void create_ThrowsIllegalArgumentException_IfCarListIsNullOrEmpty(List<Car> cars) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new Cars(cars));
    }

    @DisplayName("생성")
    @Test
    void create() {
        List<Car> initCars = Arrays.asList(new Car("bmw"), new Car("audi"), new Car("benz"));
        Cars cars = new Cars(initCars);
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

//    @DisplayName("우승자 찾기")
//    @Test
//    void findWinners() {
//        Car car1 = createMovedCar("bmw", 2);
//        Car car2 = createMovedCar("audi", 3);
//        Car car3 = createMovedCar("benz", 1);
//
//        Cars cars = new Cars(Arrays.asList(car1, car2, car3));
//        List<Car> winners = cars.findWinners();
//
//        assertThat(winners).hasSize(1);
//        assertThat(winners).containsExactly(car2);
//    }
//
//    @DisplayName("복수 우승자 찾기")
//    @Test
//    void findWinners_MultipleWinners_IfMoveCountAreSame() {
//        Car car1 = createMovedCar("bmw", 2);
//        Car car2 = createMovedCar("audi", 3);
//        Car car3 = createMovedCar("benz", 3);
//
//        Cars cars = new Cars(Arrays.asList(car1, car2, car3));
//        List<Car> winners = cars.findWinners();
//
//        assertThat(winners).hasSize(2);
//        assertThat(winners).containsOnly(car2, car3);
//    }
//
//    private static Car createMovedCar(String carName, int moveCount) {
//        Car car = new Car(carName);
//        IntStream.range(0, moveCount)
//                .forEach((index) -> car.move(() -> true));
//        return car;
//    }
}
