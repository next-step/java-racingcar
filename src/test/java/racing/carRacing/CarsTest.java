package racing.carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("cars 초기화 테스트")
    void carsInitTest() {
        Cars cars = Cars.initCars("test1,test2", () -> true);

        assertThat(cars.getCarsSize()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {",", ",,"})
    @DisplayName("input으로 콤마(,)만 있을 때 에러 반환")
    void onlyCommaErrorTest(String input) {
        assertThatThrownBy(() -> Cars.initCars(input, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요");
    }

    @Test
    @DisplayName("cars 단독 우승자 구하기")
    void getWinnerTest() {
        Cars cars = Cars.initCars("test1,test2,test3", () -> true);

        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(1).run(() -> true);
        cars.getCurrentCar(1).run(() -> true);

        String winner = cars.getWinner();

        assertThat(winner).isEqualTo("test1");
    }

    @Test
    @DisplayName("cars 복수 우승자 구하기")
    void getMultipleWinnerTest() {
        Cars cars = Cars.initCars("test1,test2,test3", () -> true);

        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(1).run(() -> true);
        cars.getCurrentCar(1).run(() -> true);

        String winner = cars.getWinner();

        assertThat(winner).isEqualTo("test1, test2");
    }

    @Test
    @DisplayName("우승자 로직 테스트")
    void winnerLogicTest() {
        int maxPosition = 2;

        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");

        car1.run(() -> true);
        car1.run(() -> true);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<String> resultList = cars.stream()
                .filter(car -> car.equalsMaxPosition(maxPosition))
                .map(Car::getCurrentCar)
                .collect(Collectors.toList());

        assertThat(resultList).containsExactly("a");
    }

    @Test
    @DisplayName("우승 자동차 위치 로직 테스트")
    void maxPositionLogicTest() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("a");
        Car car2 = new Car("b");

        car1.run(() -> true);
        car1.run(() -> true);
        car2.run(() -> true);

        cars.add(car1);
        cars.add(car2);

        int resultPosition = cars.stream()
                .mapToInt(Car::getCurrentPosition)
                .max()
                .orElse(0);

        assertThat(resultPosition).isEqualTo(2);
    }

}
