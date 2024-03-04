package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("문자열을 특정 기준으로 분리햇을 때 분리된 문자열이 기존 문자열에 포함되어야 한다.")
    public void split() throws Exception{
        //given
        String[] sutString = "1,2".split(",");

        //when
        //then
        assertThat(sutString).contains("1");
        assertThat(sutString).containsExactly("1", "2");
    }

    @Test
    @DisplayName("substring을 사용한 문자열은 문자열의 substring의 첫 번째 매개변수 값 이상, 두 번째 매개변수 값 미만 범위의 문자열이 출력되어야한다.")
    public void SubString_should_Output_Value_Between_Parameters() throws Exception{
        //given
        String sutString = "(1,2)".substring(1, 4);

        //when
        //then
        assertThat(sutString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드를 사용한 문자열은 문자열의 charAt 매개변수의 값 위치의 문자값이 반환되어야한다.")
    public void ChatAt_Should_Return_Character_IndexValuePosition() throws Exception{
        //given
        String sutString = "abc";

        //when
        char firstCharacter = sutString.charAt(0);
        char secondCharacter = sutString.charAt(1);
        char thirdCharacter = sutString.charAt(2);

        //then
        assertThat(firstCharacter).isEqualTo('a');
        assertThat(secondCharacter).isEqualTo('b');
        assertThat(thirdCharacter).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열 위치를 벗어나는 Index값을 chatAt 매개변수로 입력할 경우 StringIndexOutOfBoundsException이 발생해야 한다")
    public void Exception_Induce_With_BoundaryInput() throws Exception{
        //given
        String sutString = "abc";
        int testIndex = 3;

        //when
        //then
        assertThatThrownBy(() -> {
            sutString.charAt(testIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
