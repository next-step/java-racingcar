package step4.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameSplitterTest {

    @Test
    @DisplayName("입력된 자동차의 이름은 쉼표로 구분되어 잘린다.")
    void splitName() {
        String[] nameArr = NameSplitter.splitName("귤,수박,오렌지");

        Assertions.assertThat(nameArr).containsExactly("귤", "수박", "오렌지");
    }
}
