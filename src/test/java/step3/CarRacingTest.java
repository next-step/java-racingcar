package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.controller.CarRacing;
import step3.utility.ReturnValue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingTest {

    @Test
    @DisplayName("난수 생성 테스트")
    public void createRandom() {
        final int BIG_NUMBER = 10000;

        for (int i = 0; i < BIG_NUMBER; i++) {
            assertThat(ReturnValue.returnValue()).isBetween(0, 9);
        }
    }


    @Test
    @DisplayName("numofcar_인풋에러")
    void checkCars() {
        assertThatThrownBy(() -> {
            new CarRacing(-1, 5);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("numofcar_인풋에러");
    }

    @Test
    @DisplayName("numoftry_인풋에러")
    void checkTries() {
        assertThatThrownBy(() -> {
            new CarRacing(3, -1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("numoftry_인풋에러");
    }
}
