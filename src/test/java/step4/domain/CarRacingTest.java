package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.model.InputData;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {
    @Test
    @DisplayName("입력값 시도 회수가 0 또는 음수일 때 에러를 throw")
    void validateInputNumTry() {
        String[] players = {"pobi", "crong", "honux"};
        assertThatThrownBy(() -> new CarRacing(players, -5)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new CarRacing(players, 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값은 차량 이름이 5자 초과일 때 에러를 throw")
    void validateInputCarName() {
        String[] unusualPlayers = {"pobiiabc", "cronga", "honux"};
        assertThatThrownBy(() -> new CarRacing(unusualPlayers, 4)).isInstanceOf(IllegalArgumentException.class);
    }

}