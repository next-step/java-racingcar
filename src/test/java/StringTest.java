import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("\"1, 2\"를 \",\"로 split 했을 때 1과 2로 분리된다.")
    void string_split_test(){
        assertThat("1,2".split(",")).containsExactly("1", "2");

        assertThat("1".split(",")).containsExactly("1");
    }



    @Test
    @DisplayName("\"(1,2)\"값이 주어지면 \"1,2\"를 반환한다.")
    void string_substring_test(){
        String string = "(1,2)";
        String res =  string.substring(1, string.length()-1);
        assertThat(res).isEqualTo("1,2");
    }

    @Test
    @DisplayName("위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void charAt_exception_test(){
        String string = "abc";
        assertThatThrownBy(()->{
            string.charAt(string.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("charAt 으로 특정 위치 문자를 가져온다.")
    void charAt_test(){
        String string = "abc";
        assertThat(string.charAt(0)).isEqualTo('a');
        assertThat(string.charAt(1)).isEqualTo('b');
        assertThat(string.charAt(2)).isEqualTo('c');
    }
}
