package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp () {
        car = new Car();
    }

    @ParameterizedTest
    @DisplayName("자동차 전진")
    @CsvSource(value = {"true:2", "false:1"}, delimiter = ':')
    void stepForward (boolean isStepForward, int result) {
        car.stepForward(isStepForward);
        assertThat(car.getPosition().getPosition()).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("기준값보다 랜덤값이 크면 전진, 아니면 제자리")
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:false", "5:true", "6:true", "7:true", "8:true", "9:true"}, delimiter = ':')
    void checkOverReferenceValue (int radomNumber, boolean result) {
        assertThat(car.checkOverReferenceValue(radomNumber)).isEqualTo(result);
    }

    @Test
    @DisplayName("랜덤값 테스트(1000번 루프돌아서 10 미만 값만)")
    void getRandomInteager () {
        for (int i = 0; i < 1000; i++) {
            assertFalse(car.getRandomInteager() >= 10, "랜덤값이 10이상입니다.");
        }
    }
}