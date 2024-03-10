package util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class NameSplitterTest {

    @Test
    void 이름은_쉼표_기준으로_분할한다() {
        // given
        final String names = "pobi,crong,honux";

        // when
        final List<String> splitNames = NameSplitter.split(names);

        // then
        assertThat(splitNames).containsExactly("pobi", "crong", "honux");
    }
}
