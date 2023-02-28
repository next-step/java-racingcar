package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    //    요구사항 1
    //    "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    //    "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    //    힌트
    //    배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
    //    배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
    @Test
    void split1() {
        final String[] actual = "1,2".split(",");
        // actual contains [1,2]
        assertThat(actual).containsExactly("1","2");
    }
    
    @Test
    void split2() {
        final String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    // 요구사항 2
    // "(1,2)" 값이 주어졌을 때 String의 ??? 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
    @Test
    void name() {
        final String actual = "(1,2)".substring(1,4);
        // actual equals "1,2"
        assertThat(actual).isEqualTo("1,2");
    }

    //    요구사항 3
    //            "abc" 값이 주어졌을 때 String의 ??? 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    //            String의 ??? 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    //    JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
    //    힌트
    //    AssertJ Exception Assertions 문서 참고
    //    import static org.assertj.core.api.Assertions.*;
    //
    //    assertThatThrownBy(() -> {
    //        // ...
    //    }).isInstanceOf(IndexOutOfBoundsException.class)
    //  .hasMessageContaining("Index: 2, Size: 2");
    //  import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
    //
    //    assertThatExceptionOfType(IndexOutOfBoundsException.class)
    //    .isThrownBy(() -> {
    //        // ...
    //    }).withMessageMatching("Index: \\d+, Size: \\d+");
    //    자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
    //    assertThatIllegalArgumentException()
    //    assertThatIllegalStateException()
    //    assertThatIOException()
    //    assertThatNullPointerException()
    @DisplayName("특정위치릐 문자를 가져올 때 위치 값을 벗어나면 Exception 발생하는지 체크.")
    @Test
    void test3() {
        // 체크
        final char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo("c");
        // 예외 체크
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(()-> "abc".charAt(4));
    }


}