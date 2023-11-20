package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnerUtilsTest {

    @Test
    @DisplayName("경주차 게임 우승자를 알려준다.")
    void inform_winner() {
        // when
        String winners = WinnerUtils.inform(createRacingCars());

        // then
        assertThat(winners).isEqualTo("k5,k3");
    }

    private List<String> createRacingCars() {
        return List.of("k5", "k3");
    }
}
