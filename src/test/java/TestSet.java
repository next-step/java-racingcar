import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.isDeclaredBy;

public class TestSet {

    @Test
    void splitTest(){
        String target = "1,2";
        String[] result = target.split(",");
        assertThat(result).containsExactly("1","2");
    }
    @Test
    void splitTest2(){
        String target = "1";
        String[] splitList = target.split(",");
        assertThat(splitList).containsExactly("1");
    }

    @Test
    void splitTest3() {
        String target ="(1,2)";
        String result = target.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 테스트")
    void exceptionTest(){
        String target ="abc";
        char result = target.charAt(0);
        assertThat(result).isEqualTo('a');
        assertThatThrownBy(() -> {
            target.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 5");

    }
}
