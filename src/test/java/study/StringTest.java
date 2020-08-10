package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    // req1
    @Test
    public void req1() {
        String str = "1,2";
        String[] arr = str.split(",");
        assertThat(arr).contains("1");
        assertThat(arr).contains("2");

        String str2 = "2";
        String[] arr2 = str2.split(",");
        assertThat(arr2).containsExactly("1");
    }

    // req2
    @Test
    public void req2() {
        String str = "(1,2)";
        str.substring(0,3);
        assertThat(str).contains("1,2");
    }

    // req3
    @DisplayName("Exception 에 대한 Test")
    @Test
    public void req3() {
        assertThatThrownBy(()->{
            "abc".charAt(9);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }


    /**********************
     * 강의 내용 정리
     **********************/
    // 학습 테스트: api를 검증하는 것이라고 생각하자
    // ALT + INSERT : Class || Method 자동 완성
    // ALT + ENTER : IMPORT

    @Test
    public void split() {
        String[] values = "1,2".split(",");
        // assertj : JUNIT 에서 제공하는 assert 구문 보다 많은 기능을 제공함.
        assertThat(values).contains("1", "2");
        assertThat(values).containsExactly("1", "2"); // 순서까지 보장
    }

    @Test
    public void charAt() {
        assertThatThrownBy(()->{
            "abc".charAt(2);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
