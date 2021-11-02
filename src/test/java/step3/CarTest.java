package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("getNow를 통해 현재 위치를 받아 올 수 있다.")
    @Test
    void getCountTest() {
        Car car = new Car();
        Long expectNow = 0L;
        assertThat(car.getNow()).isEqualTo(expectNow);
    }

    @DisplayName("MoveOrStop(rand) 메서드에 4이상 10 이하 값이 오면 now가 +1 증가한다.")
    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1", "5:1"}, delimiter = ':')
    void moveOrStopTest(int input, Long expectNow) {
        Car car = new Car();
        car.moveOrStop(input);
        assertThat(car.getNow()).isEqualTo(expectNow);
    }
}