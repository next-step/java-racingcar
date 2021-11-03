package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * String 클래스에 대한 학습 테스트
 */
public class StringTest {

    /**
     *  요구사항 1
     *   - "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     *   - "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     *
     *  힌트
     *   - 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
     *   - 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
     */
    @Test
    @DisplayName("StringTest split()")
    void split(){
        assertThat("1,2".split(",")).containsExactly("1","2");
        assertThat("1".split(",")).contains("1");
    }

    /**
     *  요구사항 2
     *   - "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */
    @Test
    @DisplayName("StringTest substring()")
    void substring(){
        assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }

    /**
     *  요구사항 3
     *   - "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     *   - String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     *   - JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     *
     *  힌트
     *   - AssertJ Exception Assertions 문서 참고
     *   - https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#exception-assertion
     *
     *  자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
     *   - assertThatIllegalArgumentException()
     *   - assertThatIllegalStateException()
     *   - assertThatIOException()
     *   - assertThatNullPointerException()
     */
    @Test
    @DisplayName("StringTest charAt()")
    void charAt(){
        String param = "abc";
        assertThat(param.charAt(0)).isEqualTo('a');
        assertThat(param.charAt(1)).isEqualTo('b');
        assertThat(param.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            System.out.println("Exception 이전");
            param.charAt(10);
            System.out.println("Exception 이후");
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

//        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
//            .isThrownBy(() -> param.charAt(10));
    }
}
