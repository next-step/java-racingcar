package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningResultTest {

    @DisplayName("winningResult 생성")
    @Test
    void winningResult() {
        Cars cars = Cars.from("test1,test2,test3");
        WinningResult result = WinningResult.of(cars.getCars());
        assertThat(result.winners()).hasSize(3);
    }
}