package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.util.SplitName;
import study.validator.NameValidator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameValidatorTest {

    @Test
    @DisplayName("다섯글자 이상 입력하는 경우 IllegalArgumentException 발생")
    void overFiveWordsNameTest() {
        //given
        String name = "crongg";
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> NameValidator.carsNameValidator(name));
    }

    @Test
    @DisplayName("1글자 미만 입력하는 경우 Exception 발생")
    void 공백이름입력_테스트() {
        //given
        String name = "";
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> NameValidator.carsNameValidator(name));
    }

    @Test
    @DisplayName("StringUtils split 사용시 , 기준으로 작동한다.")
    void splitNameTest() {
        String[] string = SplitName.splitString("a,b,ggg");
        assertThat(string).containsExactly("a", "b", "ggg");
    }
}
