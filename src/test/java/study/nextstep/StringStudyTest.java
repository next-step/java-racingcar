package study.nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("학습 테스트 실습")
public class StringStudyTest {
    @Test
    public void Req1_testStringSplitByComma(){
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }

    @Test
    public void Req1_testStringSplitWithNoComma(){
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    public void Req2_testRemoveOutsideParenthesis(){
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기 학습 테스트")
    public void Req3_specificCharacterGetByCharAt(){
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("벗어난 위치에 대해 StringIndexOutOfBoundsException 테스트")
    public void Req3_testRaiseStringIndexOutOfBoundException(){
        assertThatThrownBy(() -> "abc".charAt(3))
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessage("String index out of range: %d", 3);
    }
}
