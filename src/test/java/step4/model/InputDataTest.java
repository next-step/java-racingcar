package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputDataTest {
    @Test
    @DisplayName("입력값 시도 회수가 0 또는 음수일 때 에러를 throw")
    void validateInputNumTry() {
        String[] players = {"pobi", "crong", "honux"};
        assertThatThrownBy(() -> new InputData(players, -5)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new InputData(players, -4)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값은 차량 이름이 5자 초과일 때 에러를 throw")
    void validateInputCarName() {
        String[] unusualPlayers = {"pobiiabc", "cronga", "honux"};
        assertThatThrownBy(() -> new InputData(unusualPlayers, 4)).isInstanceOf(IllegalArgumentException.class);
    }
}