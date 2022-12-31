import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    public static final String DELIMITER = ",";

    @Test
    @DisplayName(",로 연결된 숫자 문자열이 잘 분리되는지 확인한다.")
    void test_split_numbers() {
        final String[] actual = StringSupport.of("1,2").split(DELIMITER);
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    @DisplayName("단일 문자열이 잘 분리되는지 확인한다.")
    void test_split_number() {
        final String[] actual = StringSupport.of("1").split(DELIMITER);
        assertThat(actual).containsExactly("1");
    }
}