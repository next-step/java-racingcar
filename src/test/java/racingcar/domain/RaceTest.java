package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RaceTest {

    @DisplayName("Race() : 입력된 Car 개수 만큼의 Car 객체 생성")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @MethodSource("provideCarNamesForRace")
    void Race(String[] carNames, int carNum) {
        Race race = new Race(carNames, 1);

        assertThat(race.getNumberOfCars()).isEqualTo(carNum);
    }

    private static Stream<Arguments> provideCarNamesForRace() {
        return Stream.of(
                Arguments.of(new String[]{"ABC"}, 1),
                Arguments.of(new String[]{"ABC", "DEF"}, 2),
                Arguments.of(new String[]{"ABC", "DEF", "HIJ", "KLM"}, 4)
        );
    }

    @DisplayName("Race() : Car 개수 입력이 잘 못될 경우 Exception 발생")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @MethodSource("provideCarNamesAndRoundNumForException")
    void Race_ShouldThrowIllegalArgumentException(String[] carNames, int roundNum) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Race race = new Race(carNames, roundNum);
                });
    }

    private static Stream<Arguments> provideCarNamesAndRoundNumForException() {
        return Stream.of(
                // Exception due to roundNum
                Arguments.of(new String[]{"ABC"}, 0),
                // Exception due to carNames
                Arguments.of(new String[]{" ", "ABC", "DEF"}, 1),
                Arguments.of(new String[]{"ABC", " ", "DEF", "GHI"}, 1),
                Arguments.of(new String[]{"ABC", "DEF", " "}, 1),
                Arguments.of(new String[]{" "}, 1),
                Arguments.of(new String[]{""}, 1)
        );
    }

    @DisplayName("isRaceOver : 입력한 Round 만큼 Race를 진행 완료하면 true 반환")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @ValueSource(ints = {1, 3, 4, 5, 6, 7, 10})
    void isRaceOver(int roundNum) {
        Race race = new Race(new String[]{"ABC"}, roundNum);

        for (int i = 0; i < roundNum; i++) {
            race.runOneRound();
        }

        assertThat(race.isRaceOver()).isEqualTo(true);
    }

    @DisplayName("isValidCarNumes : Car의 이름에 대한 데이터 유효성 검사")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @MethodSource("provideCarNamesForisValidCarNames")
    void isValidCarNames(String[] carNames, boolean expected) {
        assertThat(Race.isValidCarNames(carNames)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCarNamesForisValidCarNames() {
        return Stream.of(
                Arguments.of(new String[]{"ABC"}, true),
                Arguments.of(new String[]{" ABC", " DEF ", "GHI "}, true),
                Arguments.of(new String[]{" ", "ABC", "DEF"}, false),
                Arguments.of(new String[]{"ABC", " ", "DEF", "GHI"}, false),
                Arguments.of(new String[]{"ABC", "DEF", " "}, false),
                Arguments.of(new String[]{" "}, false),
                Arguments.of(new String[]{""}, false)
        );
    }

    @DisplayName("isValidRoundNum : RoundNum 데이터 유효성 검사 - 최소값 이상이면 true")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @CsvSource({"-1, false", "0, false", "1, true", "3, true", "5, true", "100, true"})
    void inValidRoundNum(int roundNum, boolean expected) {
        assertThat(Race.isValidRoundNum(roundNum)).isEqualTo(expected);
    }

    Race simulateRace(int[] locations) {
        String[] carNames = new String[locations.length];

        for (int i = 0; i < locations.length; i++) {
            carNames[i] = "Car" + i;
        }

        Race race = new Race(carNames, 1);

        List<Car> cars = race.getCars();
        for (int i = 0; i < cars.size(); i++) {
            for (int j = 0; j < locations[i]; j++) {
                cars.get(i).goForward();
            }
        }

        return race;
    }

    @DisplayName("sortByLocation")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @MethodSource("provideIntsForsortByLocation")
    void sortByLocation(int[] locations, int[] expected) {
        Race race = simulateRace(locations);
        race.sortByLocation();

        int[] result = new int[locations.length];
        List<Car> cars = race.getCars();

        for (int i = 0; i < locations.length; i++) {
            result[i] = cars.get(i).getLocation();
        }

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideIntsForsortByLocation() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 3, 2, 7, 10}, new int[]{10, 7, 4, 3, 3, 2, 1}),
                Arguments.of(new int[]{0, 5, 7, 3, 10, 1 , 2, 2, 10, 9}, new int[]{10, 10, 9, 7, 5, 3, 2, 2, 1, 0})
        );
    }

    @DisplayName("getWinner : location 값이 제일 큰 Car 객체들 반환")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @MethodSource("provideIntsForgetWinner")
    void getWinner(int[] locations, int[] expected) {
        Race race = simulateRace(locations);

        List<Car> winners = race.getWinners();

        int[] result = new int[winners.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = winners.get(i).getLocation();
        }

        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideIntsForgetWinner() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 4, 3, 2, 7, 10}, new int[]{10}),
                Arguments.of(new int[]{0, 5, 7, 3, 10, 1 , 2, 2, 10, 9}, new int[]{10, 10})
        );
    }
}
