package step3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static step3.Fixture.car;

class InputDataTest {
    @Test
    @DisplayName("입력값 확인")
    void inputData() {
        int expectedNumCar = 3;
        int expectedNumTry = 5;

        InputData inputData = new InputData(3, 5);
        assertThat(inputData.getNumCar()).isEqualTo(expectedNumCar);
        assertThat(inputData.getNumTry()).isEqualTo(expectedNumTry);
    }

    @Test
    @DisplayName("입력값은 0 또는 음수일 때 에러를 throw")
    void validateInputData() {
        assertThatThrownBy(() -> new InputData(0, 5)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new InputData(-2, -4)).isInstanceOf(IllegalArgumentException.class);
    }
}