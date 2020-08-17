package racing.car.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.car.MovableRule;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private static Stream<Arguments> getCarsArguments() {
        return Stream.of(
                        Arrays.asList(new Car("lee", 0),
                                new Car("kim", 1),
                                new Car("hong", 1)),

                        Arrays.asList(new Car("tom", 3),
                                new Car("tony", 0),
                                new Car("toto", 1)),

                        Arrays.asList(new Car("min", 3),
                                new Car("mimi", 5),
                                new Car("kang", 6),
                                new Car("kim", 1),
                                new Car("park", 6))
        ).map(Arguments::of);
    }

    private static Stream<Arguments> getWinnerArguments() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(new Car("lee", 0),
                                new Car("kim", 1),
                                new Car("hong", 1)),
                        Arrays.asList(new Car("kim", 1),
                                new Car("hong", 1))),
                Arguments.of(
                        Arrays.asList(new Car("tom", 3),
                                new Car("tony", 0),
                                new Car("toto", 1)),
                        Arrays.asList(new Car("tom", 3))),
                Arguments.of(
                        Arrays.asList(new Car("min", 3),
                                new Car("mimi", 5),
                                new Car("kang", 6),
                                new Car("kim", 1),
                                new Car("park", 6)),
                        Arrays.asList(new Car("kang", 6),
                                new Car("park", 6)))
        );
    }

    @Test
    @DisplayName("레이싱 한 경기 후 결과 비교하기")
    void racingOneGame() {
        // given
        Cars cars = new Cars(Arrays.asList("park", "lee", "toto", "bibi"), 0);
        MovableRule movableRule = () -> true;

        // when
        cars.racingOneGame(movableRule);

        // then
        assertThat(cars).isNotEqualTo(new Cars(Arrays.asList("park", "lee", "toto", "bibi"), 0));
    }

    @ParameterizedTest
    @MethodSource("getCarsArguments")
    @DisplayName("trackrecords 생성하기")
    void getTrackRecords(List<Car> carList) {
        // given
        Cars cars = new Cars(carList);
        Map<String, Integer> expectedTrackRecords = getExpectedTrackRecords(carList);

        // when
        Map<String, Integer> trackRecords = cars.getTrackRecords();

        // then
        assertThat(trackRecords).isEqualTo(expectedTrackRecords);

    }

    @ParameterizedTest
    @MethodSource("getWinnerArguments")
    @DisplayName("우승자 찾기")
    void findWinner(List<Car> carList, List<Car> expectedWinners) {
        // given
        Cars cars = new Cars(carList);

        // when
        List<Car> winners = cars.findWinner();

        // then
        assertThat(winners).isEqualTo(expectedWinners);
    }

    private Map<String, Integer> getExpectedTrackRecords(List<Car> carList) {
        Map<String, Integer> expectedTrackRecords = new LinkedHashMap<>();
        for (Car car : carList) {
            expectedTrackRecords.put(car.getName(), car.getLocation());
        }

        return expectedTrackRecords;
    }

}