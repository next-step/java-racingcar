package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        //System.out.println(result);
    }

    @Test
    @DisplayName("String 클래스에 대한 학습 테스트 - 요구사항 3")
    void charAt_String(){
    }

    // Set Collection에 대한 학습 테스트

    // 요구사항 1

    // 요구사항 2

    // 요구사항 3
}
