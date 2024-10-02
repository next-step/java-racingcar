package racing.input;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceLineupTest {

    static String inputNames = "pobi,crong,honux";

    static List<String> names = RaceLineUp.of(inputNames).names();

    @Test
    void 자동차_이름_리스트_요소() {
        assertThat(names).contains(inputNames.split(","));
    }

    @Test
    void 자동차_이름_추가불가() {
        assertThatThrownBy(() -> names.add(""))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 자동차_이름_제거불가() {
        assertThatThrownBy(() -> names.remove(names.size() - 1))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void 자동차_이름_수정_시_원본유지() {
        assertThatThrownBy(() -> names.set(names.size() - 1, ""))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
