package racingcar.service.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.service.domain.factory.RecordFactory;
import racingcar.service.value.Round;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static racingcar.service.domain.TestCarMaker.secondPlace;
import static racingcar.service.domain.TestCarMaker.victory;

class RecordTest {

    @ParameterizedTest
    @MethodSource(value = "getFinalWinnerName")
    @DisplayName("각 경기별로 우승자 검증")
    void getFinalWinnerName(Round round, List<Car> cars, String winner) {
        // given
        Record record = RecordFactory.create(round, cars);

        // when
        String result = record.getFinalWinnerName();

        // then
        assertThat(result).isEqualTo(winner);
    }

    @ParameterizedTest
    @MethodSource(value = "createRecordException")
    @DisplayName("Record의 필수값이 null인 경우 예외 발생 검증")
    void createRecordException(Round round, List<Car> cars) {
        // when & then
        assertThatNullPointerException().isThrownBy(() -> RecordFactory.create(round, cars));
    }

    private static Stream<Arguments> getFinalWinnerName() {
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

    private static Stream<Arguments> createRecordException() {
        // given
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(Round.from(10), null),
                Arguments.of(null, Collections.singletonList(new Car("aiden")))
        );
    }
}
