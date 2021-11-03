package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("getPosition 을 통해 현재 위치를 받아 올 수 있다.")
    @Test
    void getCountTest() {
        Car car = Car.create(() -> true);
        Integer expectNow = 0;
        assertThat(car.getPosition()).isEqualTo(Position.create(expectNow));
    }

    @DisplayName("MoveOrStop() strategy의 test의 결과가 true이면 position이 1 증가한다.")
    @ParameterizedTest
    @CsvSource(value = {"3:1", "4:1", "5:1"}, delimiter = ':')
    void moveTest(Integer input, Integer expectNow) {
        Car car = Car.create(() -> true);
        car.moveOrStop();
        assertThat(car.getPosition()).isEqualTo(Position.create(expectNow));
    }

    @DisplayName("MoveOrStop() strategy의 test의 결과가 false이면 position은 변하지 않는다.")
    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:0", "5:0"}, delimiter = ':')
    void stopTest(Integer input, Integer expectNow) {
        Car car = Car.create(() -> false);
        car.moveOrStop();
        assertThat(car.getPosition()).isEqualTo(Position.create(expectNow));
    }
}