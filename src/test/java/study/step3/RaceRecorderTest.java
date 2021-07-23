package study.step3;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceRecorderTest {

    RaceRecorder raceRecorder = new RaceRecorder();

    @Test
    @DisplayName("cars 가 null 인 경우")
    public void nullCars() {
        // given
        List<Car> cars = null;
        String message = RaceRecorder.NON_NULL;

        // when
        ThrowingCallable throwingCallable = () -> raceRecorder.prepareRecord(cars);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "경주 시작전 세팅 확인 | {arguments}")
    @CsvSource(value = {"1:1", "3:3", "5:5"}, delimiter = ':')
    public void checkBeforeRaceSetting(int carNumber, int expected) {
        // given
        int startPosition = 1;
        List<Car> cars = IntStream.range(0, carNumber)
                .mapToObj(i -> new Car(startPosition))
                .collect(Collectors.toList());
        String expectedRecord = IntStream.range(0, expected)
                .mapToObj(i -> "-")
                .collect(Collectors.joining("\n", "", "\n\n"));

        // when
        raceRecorder.prepareRecord(cars);

        // then
        assertThat(raceRecorder.getAllRoundRecords()).isEqualTo(expectedRecord);
    }

}
