package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

//    @DisplayName("Race() : 입력된 Car 개수 만큼의 Car 객체 생성")
//    @ParameterizedTest(name = "{index} {displayName} {arguments}")
//    @MethodSource("provideCarNamesForRace")
//    void Race(String[] carNames, int carNum) {
//        Race race = new Race(carNames, 1);
//
//        assertThat(race.getNumberOfCars()).isEqualTo(carNum);
//    }
//
//    private static Stream<Arguments> provideCarNamesForRace() {
//        return Stream.of(
//                Arguments.of(new String[]{"ABC"}, 1),
//                Arguments.of(new String[]{"ABC", "DEF"}, 2),
//                Arguments.of(new String[]{"ABC", "DEF", "HIJ", "KLM"}, 4)
//        );
//    }

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

    @DisplayName("isValidRoundNum : RoundNum 데이터 유효성 검사 - 최소값 이상이면 true")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @CsvSource({"-1, false", "0, false", "1, true", "3, true", "5, true", "100, true"})
    void inValidRoundNum(int roundNum, boolean expected) {
        Race race = new Race();
        assertThat(race.isValidRoundNum(roundNum)).isEqualTo(expected);
    }
}
