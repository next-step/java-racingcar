package com.next.step.step3.service;

import com.next.step.step3.domain.Car;
import com.next.step.step3.domain.Cars;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerElectionTest {

    @ParameterizedTest(name = "자동차가 레이싱 완료 후 한 명의 우승자가 존재하는지 테스트")
    @MethodSource("provideOneWinnerCars")
    void electionWinners_우승자_한_명_테스트(Cars cars, List<String> expected) {
        List<String> result = WinnerElection.electionWinners(cars);
        assertThat(result).containsAnyElementsOf(expected);
    }

    static Stream<Arguments> provideOneWinnerCars() {
        return Stream.of(
                Arguments.of(new Cars(oneWinnerCars()), List.of("c"))
        );
    }

    private static List<Car> oneWinnerCars() {
        return List.of(
                new Car(1, "a"),
                new Car(2, "b"),
                new Car(3, "c")
        );
    }

    @ParameterizedTest(name = "자동차가 레이싱 완료 후 여러 명의 우승자가 존재하는지 테스트")
    @MethodSource("provideManyWinnerCars")
    void electionWinners_우승자_여러_명_테스트(Cars cars, List<String> expected) {
        List<String> result = WinnerElection.electionWinners(cars);
        assertThat(result).containsAnyElementsOf(expected);
    }

    static Stream<Arguments> provideManyWinnerCars() {
        return Stream.of(
                Arguments.of(new Cars(manyWinnerCarsCase1()), List.of("a", "b", "c")),
                Arguments.of(new Cars(manyWinnerCarsCase2()), List.of("b", "c"))
        );
    }

    private static List<Car> manyWinnerCarsCase1() {
        return List.of(
                new Car(1, "a"),
                new Car(1, "b"),
                new Car(1, "c")
        );
    }

    private static List<Car> manyWinnerCarsCase2() {
        return List.of(
                new Car(1, "a"),
                new Car(100, "b"),
                new Car(100, "c")
        );
    }
}
