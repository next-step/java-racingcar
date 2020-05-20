package racingCar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameWinnersTest {

    @ParameterizedTest
    @MethodSource("provideRacingData")
    void getWinnerNames(List<RacingCar> racingCarList, String[] expect) {
        RacingGameWinners gameResult = new RacingGameWinners(racingCarList);
        List<String> winnerNames = gameResult.getWinnerNames();

        assertThat(winnerNames).hasSize(expect.length).containsAll(Arrays.asList(expect));
    }

    private static Stream<Arguments> provideRacingData() {
        List<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(new RacingCar("Ape"));
        racingCarList.add(new RacingCar("Frodo"));
        racingCarList.add(new RacingCar("Tube"));
        racingCarList.add(new RacingCar("Con"));
        racingCarList.add(new RacingCar("Ryan"));

        return Stream.of(Arguments.of(racingCarList, new String[]{"Frodo","Tube"}));
    }
}
