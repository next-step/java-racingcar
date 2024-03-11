import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("String 클래스 학습 테스트")
public class StringTest {

    @Test
    @DisplayName(",를 포함한 문자열을 ,기준으로 분리하면 배열이 반환된다")
    public void splitComma() {
        assertThat(StringUtils.split("1,2", ",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열에 ,가 없어도 ,기준으로 분리하면 배열이 반환된다")
    public void splitComma2() {
        assertThat(StringUtils.split("1", ",")).contains("1");
    }


    @Test
    @DisplayName("문자열에서 특정 위치의 문자를 반환한다")
    public void findIndexTest() {
        assertThat(StringUtils.chatAt("abc", 2)).isEqualTo('c');
    }

    @Test
    @DisplayName("문자열 인덱스 범위를 벗어나면 예외가 발생한다")
    public void findIndexExceptionTest() {
        Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> StringUtils.chatAt("abc", 10));
    }


}
