package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("CarName 들을 받아 Cars 객체가 생성된다")
    @Test
    void createCarsWithCarNames() {
        List<CarName> names = new ArrayList<>(List.of(new CarName("carA0"), new CarName("carB")));
        Cars cars = new Cars(names);
        assertThat(cars).isNotNull();
    }

    @DisplayName("자동차들이 이동한다")
    @Test
    void moveAll() {
        Random fixedRandom = new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        };
        List<CarName> names = List.of(new CarName("carA"), new CarName("carB"));
        Cars cars = new Cars(names);
        cars.moveAll(fixedRandom);
        for (Car car : cars.allCars()) {
            assertThat(car.position()).isEqualTo(new Position(1));
        }
    }

    @DisplayName("라운드 결과를 구한다")
    @Test
    void roundResult() {
        Car a = new Car(new CarName("car1"), new Position(3));
        Car b = new Car(new CarName("car2"), new Position(2));
        Cars cars = Cars.fromCars(List.of(a, b));
        List<String> result = cars.roundResult();
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly("car1 : ---", "car2 : --");
    }

    @DisplayName("우승자 이름을 구한다")
    @Test
    void singleWinnerName() {
        Car a = new Car(new CarName("car1"), new Position(3));
        Car b = new Car(new CarName("car2"), new Position(2));
        Cars cars = Cars.fromCars(List.of(a, b));
        List<String> winners = cars.winnerNames();
        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactly("car1");
    }

    @DisplayName("공동 우승자 이름을 구한다")
    @Test
    void multipleWinnersNames() {
        Car a = new Car(new CarName("car1"), new Position(3));
        Car b = new Car(new CarName("car2"), new Position(3));
        Cars cars = Cars.fromCars(List.of(a, b));
        List<String> winners = cars.winnerNames();
        assertThat(winners).hasSize(2);
        assertThat(winners).containsExactly("car1", "car2");
    }
}