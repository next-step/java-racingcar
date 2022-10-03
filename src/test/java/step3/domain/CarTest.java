package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("moveByRandomOnRound에 4미만의 숫자가 전달되면 기록이 0, 4이상은 기록이 1이 되어야함")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @CsvSource(value = {"0:0", "1:0", "3:0", "4:1", "8:1", "9:1"}, delimiter = ':')
    void moveByRandomOnRound(int randomNumber, int increaseRecord) {
        Car car = new Car("abc");
        car.moveByRandomOnRound(() -> randomNumber);
        assertThat(car.getRecord().getLastRecord()).isEqualTo(increaseRecord);
    }
}
