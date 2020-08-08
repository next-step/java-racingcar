package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    /*
     * 1단계 - 학습테스트 실습
     * String 클래스에 대한 학습 테스트
     */

    // 요구사항 1
    @Test
    //Alt+Insert > method auto create
    public void split() {
        String[] values = "1,2".split(",");     //regex ?
        assertThat(values) .contains("1", "2");  //Alt+Enter > Library Import
    }

    // 요구사항 2
    @Test
    public void substring() {
        String value = "(1,2)";
        String substrValue = value.substring(1,4);
        System.out.println(substrValue);
    }

    // 요구사항 3
    @Test
    public void charAt() {
        assertThatThrownBy(() -> {
            "abc".charAt(2);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
