package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SourceTest {

    @Test
    void 문자_분리() {
        Source spliter = new Source();
        assertThat(spliter.split("1,2,3")).containsOnly("1", "2", "3");
        assertThat(spliter.split("1:2,3")).containsOnly("1", "2", "3");
        assertThat(spliter.split("////\n1//2//3")).containsOnly("1", "2", "3");
    }
}