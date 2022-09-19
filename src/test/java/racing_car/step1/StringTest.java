package racing_car.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    
    @Nested
    @DisplayName("split 테스트")
    class StringSplit {
        @DisplayName("1과 2를 쉼표로 split")
        @ParameterizedTest(name = "{displayName} : {0}")
        @ValueSource(strings = {"1", "2"})
        void two_split(String element) {
            String[] split = "1,2".split(",");
            assertThat(split).contains(element);
        }
        
        @Test
        @DisplayName("1 하나를 쉼표로 split : only 1")
        void one_split() {
            String[] split = "1".split(",");
            assertThat(split).containsExactly("1");
        }
    }
    
    @Test
    @DisplayName("(1,2)를 괄호 제거 후 반환 : 1,2")
    void substring() {
        String testStr = "(1,2)";
        String substring = testStr.substring(1, testStr.length() - 1);
        assertThat(substring).isEqualTo("1,2");
    }
    
    
    @Nested
    @DisplayName("charAt() 테스트")
    class StringCharAt {
        private String str;
        
        @BeforeEach
        void setUp() {
            str = "abc";
        }
        
        @DisplayName("charAt() 특정 위치 문자 가져오기")
        @ParameterizedTest(name = "{displayName} : index = {0}, result = {1}")
        @CsvSource(value = {"0, a", "1, b", "2, c"})
        void charAt(int idx, char result) {
            assertThat(str.charAt(idx)).isEqualTo(result);
        }
        
        @DisplayName("charAt() 인덱스 벗어날 시 예외 발생 테스트")
        @ParameterizedTest(name = "{displayName} : index = {0}")
        @ValueSource(ints = {-1, 3})
        void charAt_exception(int idx) {
            assertThatThrownBy(() -> str.charAt(idx))
                    .isInstanceOf(IndexOutOfBoundsException.class)
                    .hasMessageContaining("index out of range: %d", idx);
        }
    }
}
