package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingCar.domain.CarNameSplitter;

class CarNameSplitterTest {

    @Test
    @DisplayName("자동차의 이름이 잘 나뉘는지 확인한다.")
    void test1() {
        String input = "pobi,crong,honux";

        assertThat(CarNameSplitter.names(input).get(0).isEqual("pobi")).isTrue();
        assertThat(CarNameSplitter.names(input).get(1).isEqual("crong")).isTrue();
        assertThat(CarNameSplitter.names(input).get(2).isEqual("honux")).isTrue();
    }
}
