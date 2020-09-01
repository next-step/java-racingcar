package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.strategy.DefaultMoveStategy;
import racing.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    @DisplayName("우승자리스트 찾기")
    @ParameterizedTest
    @MethodSource("getCars")
    public void 우승자찾기(String[] inputs, int roundOfRacing, MoveStrategy strategy, ArrayList<String> expected) {

        RacingCars cars = RacingCars.of(inputs);
        cars.startRacing(roundOfRacing, strategy);

        assertThat(Winners.getWinner(cars)).isEqualTo(expected);
    }

    @DisplayName("최대갑 구하기")
    @ParameterizedTest
    @MethodSource("getCarsWithMaxRecord")
    public void 최대값구하기(String[] inputs, int roundOfRacing, MoveStrategy strategy, int expected) {

        RacingCars cars = RacingCars.of(inputs);
        cars.startRacing(roundOfRacing, strategy);

        assertThat(Winners.getMaxRecord(cars.getRecingCarList())).isEqualTo(expected);
    }

    static Stream<Arguments> getCars() {
        String[] inputs = Stream.<String>builder().add("경현")
                .add("에디")
                .add("슈마허")
                .build()
                .toArray(String[]::new);

        ArrayList<String> excpected = Stream.<String>builder().add("경현")
                .add("에디")
                .add("슈마허")
                .build()
                .collect(toCollection(ArrayList<String>::new));

        return Stream.of(
                Arguments.of(inputs, 3, new DefaultMoveStategy(), excpected)
        );
    }
    static Stream<Arguments> getCarsWithMaxRecord() {
        String[] inputs = Stream.<String>builder().add("경현")
                .add("에디")
                .add("슈마허")
                .build()
                .toArray(String[]::new);


        return Stream.of(
                Arguments.of(inputs, 3, new DefaultMoveStategy(), 3)
        );
    }
}
