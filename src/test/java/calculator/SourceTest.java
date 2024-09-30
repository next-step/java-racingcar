package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SourceTest {
    @Test
    @DisplayName("문자 분리 테스트")
    void splitTest() {
        Source source = new Source();
        assertThat(source.split("1,2,3")).containsOnly("1", "2", "3");
        assertThat(source.split("1:2,3")).containsOnly("1", "2", "3");
        assertThat(source.split("////\n1//2//3")).containsOnly("1", "2", "3");
    }
}