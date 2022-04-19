package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SplitStringTest {

    @Test
    void split_이름을_입력받는다() {
        List<String> name = SplitString.split("wu2ee");
        assertThat(name.get(0)).isEqualTo("wu2ee");
    }

    @Test
    void split_이름을_2개이상_입력받는다() {
        List<String> name = SplitString.split("pobi,wu2ee");
        assertThat(name).contains("wu2ee", "pobi");
    }
}