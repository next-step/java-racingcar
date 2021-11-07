package racingcar.service.domain.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.service.domain.Car;
import racingcar.service.domain.Record;
import racingcar.service.value.Round;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class RecordFactoryTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("정상적으로 Record가 생성되는 경우")
    void create(Integer round, List<Car> cars) {
        // when
        Record record = RecordFactory.create(round, cars);

        // then
        assertThat(record).isNotNull();
        assertThat(record.getCurrentRound()).isEqualTo(Round.from(round));
        assertThat(record.getCars().getCarList()).isEqualTo(cars);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("이름에 공백이나 null이 들어가는 경우 예외 처리")
    void createException(Integer round, List<Car> cars) {
        // when & then
        assertThatNullPointerException().isThrownBy(() -> RecordFactory.create(round, cars));
    }

    private static Stream<Arguments> create() {
        // given
        return Stream.of(
                Arguments.of(1,
                             Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux"))
                ),
                Arguments.of(2,
                             Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux"))
                ),
                Arguments.of(3,
                             Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux"))
                )
        );
    }

    private static Stream<Arguments> createException() {
        // given
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(10, null),
                Arguments.of(null, Collections.singletonList(new Car("aiden")))
        );
    }
}
