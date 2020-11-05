package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingInputTest {
    private RacingInput input;

    @BeforeEach
    void setUp() {
        input = new RacingInput(5, 3);
    }

    @Test
    @DisplayName("정상적으로 자동차 수 반환되는지 확인")
    void checkCountOfCars() {
        assertThat(input.getCountOfCar()).isEqualTo(5);
    }

    @Test
    @DisplayName("정상적으로 라운드 수 반환되는지 확인")
    void checkCountOfRound() {
        assertThat(input.getCountOfRound()).isEqualTo(3);
    }

}