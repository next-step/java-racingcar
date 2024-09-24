package study.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CharAtTest {

    @Test
    @DisplayName("a추출 테스트")
    public void popATest(){
        char a = "abc".charAt(0);
        assertThat(a).isEqualTo('a');
        assertThat(a).isNotEqualTo("a");
    }

    @Test
    @DisplayName("인덱스 밖 요소 추출")
    public void popOutIndex(){
        assertThatThrownBy(()->"abc".charAt(-1)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
