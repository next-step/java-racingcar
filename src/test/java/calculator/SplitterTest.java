package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {

    @Test
    @DisplayName("텍스트를 쉼표와 콜론으로 구분한다.")
    void 텍스트를_쉼표와_콜론으로_구분한다() {
        Splitter splitter = new Splitter();
        String text = "1,2,3;4";

        String[] split = splitter.split(text);

        assertThat(split).containsAnyOf("1", "2", "3", "4");
    }

    @Test
    @DisplayName("커스텀 구분자가 있을 경우 커스텀 구분자로 구분한다.")
    void 커스텀_구분자가_있을_경우_커스텀_구분자로_구분한다() {
        Splitter splitter = new Splitter();
        String text = "//#\n1#2#3#r4";

        String[] split = splitter.split(text);

        assertThat(split).containsAnyOf("1", "2", "3", "4");
    }
}