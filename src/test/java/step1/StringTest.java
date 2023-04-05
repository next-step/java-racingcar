package step1;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : 0giri
 * @since : 2023/04/05
 */
public class StringTest {

    @DisplayName("문자열 내 존재하는 구분자로 나누면 구분된 문자열의 순서가 유지되는 문자열 배열을 얻는다")
    @Test
    void split_ShouldReturnMultipleElementsStringArrayForStringWithSeparator() {
        //given
        String target = "1,2";
        //when
        String[] result = target.split(",");
        //then
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("문자열 내 존재하지 않는 구분자로 나누면 해당 문자열 하나만 존재하는 문자열 배열을 얻는다")
    @Test
    void split_ShouldReturnSingleElementStringArrayForStringWithoutSeparator() {
        //given
        String target = "1";
        //when
        String[] result = target.split(",");
        //then
        assertThat(result).hasSize(1);
        assertThat(result).containsExactly("1");
    }

    @DisplayName("인덱스 범위로 문자열의 앞과 뒤를 제외한 중간 부분을 얻는다")
    @Test
    void substring_ShouldReturnInnerStringByRangeIndexes() {
        //given
        String target = "(1,2)";
        //when
        int length = target.length();
        String result = target.substring(1, length - 1);
        //then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("문자열 내 특정 인덱스의 문자를 추출한다")
    @Test
    void charAt_ShouldReturnSpecificCharacterByIndex() {
        //given
        String target = "abc";
        //when
        char result = target.charAt(1);
        //then
        assertThat(result).isEqualTo('b');
    }

    @DisplayName("문자열 길이를 벗어난 인덱스를 지정하면 StringIndexOutOfBoundsException을 발생시킨다")
    @Test
    void charAt_ShouldThrowStringIndexOutOfBoundsExceptionByOverRangeIndex() {
        //given
        ThrowingCallable target = () -> "abc".charAt(10);
        //when
        //then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(target)
            .withMessageMatching("String index out of range: \\d+");
    }

}
