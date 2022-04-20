package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @DisplayName("자동차 대수를 입력했을 때 Cars가 정상적으로 생성되는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "a  ,b#, c", "abcde,12345,!@#$%", "-12#4, a1cd,!@s34", "a, b", "ad", "a,b,"})
    void constructCarsTest(String carsName) {
        Cars cars = new Cars(carsName);
        List<Car> carList = (List<Car>) ReflectionTestUtils.getField(cars, "cars");
        assertThat(carList).hasSize(carsName.split(",").length);
    }

    @DisplayName("자동차 대수를 입력했을 때 Cars가 정상적으로 생성되는지 테스트 - 실패 케이스")
    @ParameterizedTest
    @ValueSource(strings = {",a,b", "abcdef,a,c", "a,,a", ",12345"})
    void constructCarsFailTest(String carsName) {
        assertThatThrownBy(() -> new Cars(carsName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("movable 전략에 따라 자동차가 움직이는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"a,b,c:true:1", "a,b,c:false:0"}, delimiter = ':')
    void moveCarsTest(String carsName, boolean movable, int distance) {
        Cars cars = new Cars(carsName);

        Map<String, Integer> result = cars.moveCars(TestMoveStrategy.getInstance(movable));

        result.keySet()
                .forEach(carName -> assertThat(result.get(carName)).isEqualTo(distance));
    }

    @DisplayName("우승자 찾기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"a,b,c:true:a", "a,b,c:false:a,b", "a,b,c:false:a,b,c"}, delimiter = ':')
    void findWinnersTest(String carsName, boolean movable, String additionalMove) {
        Cars cars = new Cars(carsName);
        cars.moveCars(TestMoveStrategy.getInstance(movable));
        List<Car> carList = (List<Car>) ReflectionTestUtils.getField(cars, "cars");

        List<String> additionalMoveCars = Arrays.stream(additionalMove.split(","))
                .collect(Collectors.toList());
        for (Car car : carList) {
            if (additionalMoveCars.contains(car.getName())) {
                car.move(TestMoveStrategy.getInstance(true));
            }
        }

        List<String> winners = cars.findWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        assertThat(winners.equals(additionalMoveCars)).isTrue();
    }

    @Test
    void test() {
        String[] split = ",a,b".split(",");
        for (String s : split) {
            System.out.println("[" + s + "]");
        }
    }
}