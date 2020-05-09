package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;


public class StringTest {
    @Test
    void ExistDelimiterSplitTestFunction() {
        String[] result ="1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }
    @Test
    void NotExistDelimiterSplitTestFunction() {
        String[] result ="1".split(",");
        assertThat(result).containsExactly("1");
    }
    @Test
    void SubstringTestFunction() {
        String result ="(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }
    @Test
    @DisplayName("String 클레스의 charAt Function에서 스트링의 허용 위치 값을 벗어났을 경우 발생하는 StringIndexOutOfBoundsException 테스트")
    void StringIndexOutOfBoundsExceptionTestFunction() {
        String provideData ="abc";
        assertThatThrownBy(() -> {
            provideData.charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }

}
