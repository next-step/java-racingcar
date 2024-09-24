package study.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CharAtTest {
    private static final String ABC ="abc";

    @ParameterizedTest
    @DisplayName("a추출 테스트")
    @CsvSource(value = {"0,a","1,b","2,c"})
    public void popATest(int index,char result){
        assertThat(ABC.charAt(index)).isEqualTo(result);
    }

    @Test
    @DisplayName("인덱스 밖 요소 추출")
    public void popOutIndex(){
        assertThatThrownBy(()->ABC.charAt(-1)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
