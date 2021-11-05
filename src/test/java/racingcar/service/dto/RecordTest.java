package racingcar.service.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.service.domain.Car;
import racingcar.service.domain.strategy.RandomResultFalse;
import racingcar.service.domain.strategy.RandomResultTrue;
import racingcar.service.strategy.RoundRule;
import racingcar.value.Round;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class RecordTest {

    @ParameterizedTest
    @MethodSource(value = "getRoundWinnerName")
    @DisplayName("각 경기별로 우승자 검증")
    void getRoundWinnerName(Round round, List<Car> cars, String winner) {
        // given
        Record record = Record.of(round, cars);

        // when
        String result = record.getRoundWinnerName();

        // then
        assertThat(result).isEqualTo(winner);
    }

    @ParameterizedTest
    @MethodSource(value = "createRecordException")
    @DisplayName("Record의 필수값이 null인 경우 예외 발생 검증")
    void createRecordException(Round round, List<Car> cars) {
        // when & then
        assertThatNullPointerException().isThrownBy(() -> Record.of(round, cars));
    }

    public static Stream<Arguments> getRoundWinnerName() {
        // given
        return Stream.of(
                Arguments.of(Round.from(1),
                             Arrays.asList(victory("pobi"), secondPlace("crong"), secondPlace("honux")),
                             "pobi"
                ),
                Arguments.of(Round.from(2),
                             Arrays.asList(secondPlace("pobi"), victory("crong"), secondPlace("honux")),
                             "crong"
                ),
                Arguments.of(Round.from(3),
                             Arrays.asList(secondPlace("pobi"), secondPlace("crong"), victory("honux")),
                             "honux"
                ),
                Arguments.of(Round.from(4),
                             Arrays.asList(victory("pobi"), victory("crong"), secondPlace("honux")),
                             "pobi, crong"
                ),
                Arguments.of(Round.from(5),
                             Arrays.asList(victory("pobi"), victory("crong"), victory("honux")),
                             "pobi, crong, honux"
                )
        );
    }

    public static Stream<Arguments> createRecordException() {
        // given
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(Round.from(10), null),
                Arguments.of(null, Collections.singletonList(new Car("aiden")))
        );
    }

    private static Car victory(String name) {
        return createTestCar(name, new RandomResultTrue());
    }

    private static Car secondPlace(String name) {
        return createTestCar(name, new RandomResultFalse());
    }

    private static Car createTestCar(String name, RoundRule roundRule) {
        Car car = new Car(name);
        car.race(roundRule);
        return car;
    }
}
