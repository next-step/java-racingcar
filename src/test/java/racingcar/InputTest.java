package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.*;

class InputTest {
    @Test
    void inputTest_split() {
        assertThat(InputView.split("pobi,crong,honux")
                .stream()
                .map(CarName::getName)
        ).contains("pobi", "crong", "honux");
    }
}
