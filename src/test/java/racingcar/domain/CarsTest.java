package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.exception.InvalidCarCountException;
import racingcar.dto.RecordDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("자동차 일급 컬렉션 테스트")
public class CarsTest {

    @DisplayName("자동차 이동 기록")
    @ParameterizedTest
    @MethodSource("getMovedCars")
    public void getRecords(Cars cars, RecordDto[] expectedRecords) {
        List<RecordDto> records = cars.getRecords();

        assertThat(records).contains(expectedRecords);
    }

    static Stream<Arguments> getMovedCars() {
        return Stream.of(
                arguments(Cars.of(
                        Arrays.asList(
                                getMovedCar("car1", 2),
                                getMovedCar("car2", 3))),
                        new RecordDto[]{new RecordDto("car1", 2),
                                new RecordDto("car2", 3)})
        );
    }

    static Car getMovedCar(String name, int expectedPosition) {
        Car car = Car.ofName(name);
        IntStream.range(0, expectedPosition).forEach(i -> car.move());
        return car;
    }

    @DisplayName("자동차가 하나도 없을 때")
    @Test
    public void getRecordsWithEmptyCars() {
        assertThatThrownBy(() -> {
            Cars.of(new ArrayList<>());
        }).isInstanceOf(InvalidCarCountException.class)
                .hasMessageContaining("잘못된 자동차 갯수입니다.");
    }

    @DisplayName("자동차 우승자 기록")
    @ParameterizedTest
    @MethodSource("getMovedCarsForWinner")
    public void getWinnerRecords(Cars cars, RecordDto[] expectedRecords) {
        List<RecordDto> winnerRecords = cars.getWinnerRecord();

        assertThat(winnerRecords).containsOnly(expectedRecords);
    }

    static Stream<Arguments> getMovedCarsForWinner() {
        return Stream.of(
                arguments(Cars.of(
                        Arrays.asList(
                                getMovedCar("win1", 2),
                                getMovedCar("win2", 2),
                                getMovedCar("loser", 0))),
                        new RecordDto[]{new RecordDto("win1", 2),
                                new RecordDto("win2", 2)})
        );
    }
}