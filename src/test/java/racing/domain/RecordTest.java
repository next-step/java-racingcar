package racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RecordTest {

    @ParameterizedTest
    @CsvSource(value = {"붕붕이:2", "썡썡이:3", "씽씽이:4"}, delimiter = ':')
    void 자동차의_상태를_저장하는_기록_생성(String carName, int moveCount) {
        Car car = new Car(new AlwaysMovingStrategy(), carName);
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }
        Record record = Record.record(car);

        assertThat(record).isEqualTo(new Record(carName, moveCount));
    }
}