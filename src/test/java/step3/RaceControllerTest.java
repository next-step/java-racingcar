package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.RaceController;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceControllerTest {

    @Test
    @DisplayName("IllegalArgumentException_test")
    void 매개변수_사이즈_ZERO_테스트() {
        assertThatThrownBy(() -> {
            RaceController rc = new RaceController(List.of(), 10);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
