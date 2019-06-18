package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningResultTest {

    @DisplayName("winningResult 생성")
    @Test
    void winningResult() {
        List<Car> carList = new ArrayList();
        carList.add(Car.create("test1"));
        carList.add(Car.create("test2"));
        carList.add(Car.create("test3"));

        WinningResult result = WinningResult.of(carList);

        assertThat(result.getPosition()).isEqualTo(1);
        assertThat(result.getNames()).hasSize(3);
    }

    @Test
    @DisplayName("winningResult null 일 때")
    void createWhenInputNullThenFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningResult.of(new ArrayList<>()))
                .withMessageMatching("Cars can't be null");
    }
}