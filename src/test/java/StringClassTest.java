import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringClassTest {

    @Test
    public void 구분자로_분리되어야_한다() {
        //given
        String test = "1,2";

        //when
        String[] result = test.split(",");

        //then
        assertThat(result).containsExactly("1","2");
    }

    @Test
    public void 구분자가_없으면_분리되지_않는다() {
        //given
        String test = "1";

        //when
        String[] result = test.split(",");

        //then
        assertThat(result).containsExactly("1");
    }

    @Test
    public void substring_으로_괄호가_제거되어야_한다() {
        //given
        String test = "(1,2)";
        
        //when
        String result = test.substring(1, test.length()-1);

        //then
        assertThat(result).isEqualTo("1,2");
    }
    
    @Test
    public void chatAt으로_특정_위치의_문자를_가져와야_한다() {
        //given
        String test = "abc";

        //when
        char a = test.charAt(0);
        char b = test.charAt(1);
        char c = test.charAt(2);

        //then
        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');
    }
    
    @Test
    public void charAt의_범위가_벗어나면_인덱스_예외가_나야_한다() {
        //given
        String test = "abc";
        int outOfRange = test.length();

        //when then
        assertThatThrownBy(() -> test.charAt(outOfRange))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
