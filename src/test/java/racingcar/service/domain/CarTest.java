package racingcar.service.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.service.value.CarName;
import racingcar.service.value.Position;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car testCar;
    private Car testCar2;

    @BeforeEach
    void setup() {
        testCar = new Car("aiden");
        testCar2 = new Car(CarName.from("aiden"), Position.from(4));
    }

    @Test
    @DisplayName("조건이 맞는 경우 position 증가 검증")
    void increasePosition() {
        for (int i = 1; i < 10; i++) {
            testCar.startRace(() -> true);
            assertThat(testCar.getCurrentPosition().getPosition()).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("조건이 맞지 않는 경우 position 유지 검증")
    void samePosition() {
        for (int i = 0; i < 10; i++) {
            testCar.startRace(() -> false);
            assertThat(testCar.getCurrentPosition().getPosition()).isZero();
        }
    }


    @ParameterizedTest
    @DisplayName("현재 값이 4인데 maxPosition과 비교해서 winner 여부 확인")
    @CsvSource(value = {
            "3|     false",
            "4|     true",
    }, delimiter = '|')
    void isWinner(Integer maxPosition, boolean expected) {
        boolean result = testCar2.isWinner(Position.from(maxPosition));
        assertThat(result).isEqualTo(expected);
    }
}
