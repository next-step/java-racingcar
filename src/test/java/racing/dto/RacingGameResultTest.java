package racing.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.Car;
import racing.fake.FakeCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameResultTest {
    private static final int MAX_POSITION = 4;

    @ParameterizedTest
    @MethodSource("provideNotValidCars")
    @DisplayName("비어있는 cars 객체로 생성했을 경우 Exception")
    void validateCarsByEmptyList(List<Car> cars) {
        assertThatThrownBy(() -> this.createRacingGame(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideNotValidCars() {
        return Stream.of(
                Arguments.of(new ArrayList<>()),
                Arguments.of(Collections.EMPTY_LIST)
        );
    }

    @Test
    @DisplayName("cars 객체가 null일 경우 exception")
    void validateCarsByNull() {
        assertThatThrownBy(() -> this.createRacingGame(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideWinnerCars")
    @DisplayName("우승자 테스트")
    void calculateMaxPositionTest(List<Car> dummyCars, List<Car> winners) {
        RacingGameResult result = this.createRacingGame(dummyCars);
        assertThat(result.calculateWinners()).hasSize(winners.size());
//        assertThat(result.calculateWinners()).isEqualTo(winners);
    }

    @ParameterizedTest
    @MethodSource("provideFakeCars")
    @DisplayName("자동차 개수 테스트")
    void getCarsTest(List<Car> dummyCars) {
        RacingGameResult racingGameResult = this.createRacingGame(dummyCars);
        assertThat(racingGameResult.getCars()).hasSize(dummyCars.size());
    }

    private RacingGameResult createRacingGame(List<Car> cars) {
        return new RacingGameResult(cars);
    }

    private static Stream<Arguments> provideWinnerCars() {
        return Stream.of(
                Arguments.of(getFakeCars(), fineWinners())
        );
    }

    private static List<Car> getFakeCars() {
        return Arrays.asList(
                new FakeCar("test1", MAX_POSITION),
                new FakeCar("test2", MAX_POSITION - 1),
                new FakeCar("test3", MAX_POSITION - 2),
                new FakeCar("test4", MAX_POSITION),
                new FakeCar("test5", MAX_POSITION - 1)
        );
    }

    private static List<Car> fineWinners() {
        List<Car> fakeCars = getFakeCars();
        return fakeCars.stream()
                .filter(fakeCar -> fakeCar.findCurrentPosition() == MAX_POSITION)
                .collect(Collectors.toList());
    }

    private static Stream<Arguments> provideFakeCars() {
        return Stream.of(
                Arguments.of(getFakeCars())
        );
    }
}