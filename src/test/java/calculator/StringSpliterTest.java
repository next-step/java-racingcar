package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringSpliterTest {

    @Test
    @CsvSource
    void 문자_분리() {
        StringSpliter spliter = new StringSpliter();
        assertThat(spliter.split("1,2,3")).containsOnly("1","2","3");
        assertThat(spliter.split("1:2,3")).containsOnly("1","2","3");
        assertThat(spliter.split("////\n1//2//3")).containsOnly("1","2","3");
    }
}