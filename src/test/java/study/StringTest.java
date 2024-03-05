package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항 1")
    void split_String(){
        // given
        String testValue = "1,2";
        // when
        String[] result = testValue.split(",");
        // then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항 2")
    void subString_String(){
        // given
        String testValue = "(1,2)";
        // when
        String tempResult = testValue.substring(1);
        String result = tempResult.substring(0,3);
        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항 3 : charAt()에서 exception 발생시 처리")
    void charAt_String(){
        // given
        String testValue = "abc";
        // when then
        assertThatThrownBy(() -> {
            testValue.charAt(4);
            // todo : 입력 받은 index는 무엇이며 "abc"의 인덱스는 몇이다 라고 알려주고 싶음
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
