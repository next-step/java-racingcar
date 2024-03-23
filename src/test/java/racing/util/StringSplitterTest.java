package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {

    @Test
    @DisplayName("쉼표(,)를 가진 문자열을 통해 이름 개수 테스트")
    void getNameListTest() {
        String value = "lee,kim,park";
        List<String> actual = StringSplitter.getNameList(value);
        String expectedName1 = "lee";
        String expectedName2 = "kim";
        String expectedName3 = "park";
        assertThat(actual).contains(expectedName1, expectedName2, expectedName3);
    }
}
