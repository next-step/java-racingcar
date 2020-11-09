import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    // 요구사항 1
    // "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    // "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    // 힌트
    // 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
    // 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
    @Test
    void testSplit() {
        assertThat("1,2".split(",")).containsExactly("1", "2");
        assertThat("1,".split(",")).containsExactly("1");
    }

    // 요구사항 2
    // "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
    @Test
    void testSubstring() {
        String s = "(1,2)";
        assertThat(s.substring(1, s.length() - 1)).isEqualTo("1,2");
    }

    // 요구사항 3
    // "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    // String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    // JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
    @Test
    @DisplayName("String.charAt() 사용 및 인덱스를 벗어날 경우 StringIndexOutOfBoundsException 발생 테스트")
    void testCharAt() {
        String s = "abc";
        assertThat(s.charAt(0)).isEqualTo('a');
        assertThat(s.charAt(2)).isEqualTo('c');

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            s.charAt(-1);
        });

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            s.charAt(3);
        });
    }

}
