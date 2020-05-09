import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("[요구사항1] 1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 테스트")
    void splitContainExactly() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("[요구사항1] 1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인하는 테스트")
    void splitContains() {
        String[] str = "1".split(",");
        assertThat(str).contains("1");
    }

    @Test
    @DisplayName("[요구사항2] (1,2) 값에서 subString() 메소드를 이용해 ()를 제거하고 1,2를 잘 반환하는지 확인하는 테스트")
    void subString() {
        assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("[요구사항3] charAt 특정 위치 벗어날 때, StringIndexOutOfBoundsException 발생 테스트")
    void charAt() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                "abc".charAt(3);
            }).withMessageContaining("index out of range: 3");
    }
}
