package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningRacingCarTest {

    @DisplayName("자동차 이름 5자 초과시 예외 처리")
    @Test
    void carNameLengthException() {
        assertThatThrownBy(() -> {
            new WinningRacingCar("hoyeon");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @DisplayName("우승자 판별")
    @Test
    void getWinnersNames() {
        //given
        WinningRacingCar winningRacingCar = new WinningRacingCar("pobi,crong,honux");

        //when
        winningRacingCar.makeMoveCounts(Arrays.asList(1, 4, 5));
        List<String> winnerNames = winningRacingCar.getWinnerNames();

        //then
        assertThat(winnerNames).containsExactly("crong", "honux");
    }
}