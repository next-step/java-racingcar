package racingcar.service.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.service.domain.Car;
import racingcar.service.domain.strategy.RandomResultFalse;
import racingcar.service.domain.strategy.RandomResultTrue;
import racingcar.service.strategy.RoundRule;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class RecordTest {

    @ParameterizedTest
    @MethodSource(value = "winnerIsPobi")
    @DisplayName("pobi 혼자 우승하는 경우 검증")
    void getWinner_winnerIsPobi(Integer round, List<Car> cars, String winner, String loser1, String loser2) {
        // given
        Record record = Record.of(round, cars);

        // when
        List<Car> result = record.getWinner();

        // then
        assertThat(result.size()).isEqualTo(1);
        assertThat(getNames(result).contains(winner)).isTrue();
        assertThat(getNames(result).contains(loser1)).isFalse();
        assertThat(getNames(result).contains(loser2)).isFalse();
    }

    @ParameterizedTest
    @MethodSource(value = "winnerIsPobiAndCrong")
    @DisplayName("pobi와 crong이 공동 우승하는 경우 검증")
    void getWinner_winnerIsPobiAndCrong(Integer round, List<Car> cars, String winner1, String winner2, String loser) {
        // given
        Record record = Record.of(round, cars);

        // when
        List<Car> result = record.getWinner();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(getNames(result).contains(winner1)).isTrue();
        assertThat(getNames(result).contains(winner2)).isTrue();
        assertThat(getNames(result).contains(loser)).isFalse();
    }

    @ParameterizedTest
    @MethodSource(value = "createRecordException")
    @DisplayName("Recond의 필수값이 null인 경우 예외 발생 검증")
    void createRecordException(Integer round, List<Car> cars) {
        // when & then
        assertThatNullPointerException().isThrownBy(() -> Record.of(round, cars));
    }

    public static Stream<Arguments> winnerIsPobi() {
        // given
        return Stream.of(
                Arguments.of(1,
                             Arrays.asList(winner("pobi"), loser("crong"), loser("honux")),
                             "pobi",
                             "crong",
                             "honux"
                ));
    }

    public static Stream<Arguments> winnerIsPobiAndCrong() {
        // given
        return Stream.of(
                Arguments.of(1,
                             Arrays.asList(winner("pobi"), winner("crong"), loser("honux")),
                             "pobi",
                             "crong",
                             "honux"
                ));
    }

    public static Stream<Arguments> createRecordException() {
        // given
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(10, null),
                Arguments.of(null, Collections.singletonList(new Car("aiden")))
        );
    }

    private List<String> getNames(List<Car> result) {
        return result.stream().map(Car::getName).collect(Collectors.toList());
    }

    private static Car winner(String name) {
        return createTestCar(name, new RandomResultTrue());
    }

    private static Car loser(String name) {
        return createTestCar(name, new RandomResultFalse());
    }

    private static Car createTestCar(String name, RoundRule roundRule) {
        Car car = new Car(name);
        car.race(roundRule);
        return car;
    }
}
