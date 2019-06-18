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
        Cars cars = Cars.from(Names.from("test1,test2,test3"));

        WinningResult result = WinningResult.of(cars.getCars());

        assertThat(result.getPosition()).isEqualTo(Position.valueOf(1));
        assertThat(result.getNames()).hasSize(3);
    }

    @Test
    @DisplayName("winningResult null 일 때")
    void createWhenInputNullThenFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningResult.of(new ArrayList<>()))
                .withMessageMatching("cars는 null일 수 없습니다.");
    }
}