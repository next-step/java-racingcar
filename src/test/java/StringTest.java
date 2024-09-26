import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("split으로 잘 분리가 되었는지 확인한다.")
    void splitString() {
        /*
         * contains -> 해당 원소들을 가지고 있는지 확인(순서 상관 x)
         * containsExactly -> 해당 원소들을 가지고 있는지 확인(순서 상관 o)
         * */
//        Assertions.assertThat("1,2".split(",")).contains("1", "2", "3"); // failed -> 3을 가지고 있지 않기 때문
//        Assertions.assertThat("1,2".split(",")).containsExactly("2","1"); // failed -> 배열의 순서가 일치하지 않기 때문
        Assertions.assertThat("1,2".split(",")).contains("2","1");
        Assertions.assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("substring으로 잘 제거가 되었는지 확인한다.")
    void substringString() {
        Assertions.assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt을 사용하여 특정 위치의 문자를 가져온다")
    void charAtString() {
        Assertions.assertThat("abc".charAt(0)).isEqualTo('a');

        /*
         * assertThatThrownBy -> 에러가 반드시 발생해야 하는 상황을 테스트 하는 메서드
         * */
        Assertions.assertThatThrownBy(() -> { "abc".charAt(4); })
                .isInstanceOf(StringIndexOutOfBoundsException.class)// charAt()을 했을 때 정확하게 나오는 exception -> 부모 클래스인 exception 사용 가능
                .hasMessageContaining("String index out of range: 4"); // error message가 맞는 지(?)에 대해 확인하는 메소드 같다.
    }
}
