package racing.carRacing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.carRacing.model.Car;
import racing.carRacing.model.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("cars 초기화 테스트")
    void carsInitTest() {
        Cars cars = Cars.initCars(new String[]{"test1","test2"});

        assertThat(cars.getCarsSize()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {",", ",,"})
    @DisplayName("input으로 콤마(,)만 있을 때 에러 반환")
    void onlyCommaErrorTest(String input) {
        String[] splitString = input.split(",");
        assertThatThrownBy(() -> Cars.initCars(splitString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요");
    }

    @Test
    @DisplayName("같은 이름이 있을 때 에러 반환")
    void hasSameNameTest() {
        String[] carNames = {"test1", "test2", "test1"};

        assertThatThrownBy(() -> Cars.initCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("같은 이름이 있습니다.");
    }

    @Test
    @DisplayName("우승 자동차 위치 구하기")
    void maxPositionTest() {
        Cars cars = Cars.initCars(new String[]{"test1","test2","test3"});

        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(0).run(() -> true);

        assertThat(cars.getMaxPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("cars 단독 우승자 구하기")
    void getWinnerTest() {
        Cars cars = Cars.initCars(new String[]{"test1","test2","test3"});

        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(1).run(() -> true);
        cars.getCurrentCar(1).run(() -> true);

        List<String> winner = cars.getWinners();

        assertThat(winner).containsExactly("test1");
    }

    @Test
    @DisplayName("cars 복수 우승자 구하기")
    void getMultipleWinnerTest() {
        Cars cars = Cars.initCars(new String[]{"test1","test2","test3"});

        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(0).run(() -> true);
        cars.getCurrentCar(1).run(() -> true);
        cars.getCurrentCar(1).run(() -> true);

        List<String> winner = cars.getWinners();

        assertThat(winner).containsExactly("test1", "test2");
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

    @Test
    @DisplayName("stream max 테스트")
    void streamMaxTest() {
        List<Integer> numbers = List.of(4, 0, 5, 2, 7, 1, 8, 6, 9, 3);
        int max = numbers.stream()
                .max(Integer::compareTo)
                .orElse(-1);
    }

}
