package com.next.step.step3.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    @ParameterizedTest(name = "자동차가 레이싱 완료 후 한 명의 우승자가 존재하는지 테스트")
    @MethodSource("provideOneWinnerCars")
    void electionWinners_우승자_한_명(Winner winner, List<String> expected) {
        List<String> result = winner.getWinnerNames();
        assertThat(result).containsAnyElementsOf(expected);
    }

    @ParameterizedTest(name = "자동차가 레이싱 완료 후 여러 명의 우승자가 존재하는지 테스트")
    @MethodSource("provideManyWinnerCars")
    void electionWinners_우승자_여러_명(Winner winner, List<String> expected) {
        List<String> result = winner.getWinnerNames();
        assertThat(result).containsAnyElementsOf(expected);
    }

    static Stream<Arguments> provideOneWinnerCars() {
        return Stream.of(
                Arguments.of(new Winner(new Cars(WinnerCarsFixture.한_명의_우승자_경우_CARS())), List.of("c"))
        );
    }

    static Stream<Arguments> provideManyWinnerCars() {
        return Stream.of(
                Arguments.of(new Winner(new Cars(WinnerCarsFixture.모두_우승한_경우_CARS())), List.of("a", "b", "c")),
                Arguments.of(new Winner(new Cars(WinnerCarsFixture.B_C가_우승한_경우_CARS())), List.of("b", "c"))
        );
    }
}
