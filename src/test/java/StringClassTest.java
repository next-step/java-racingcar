import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringClassTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void split_contains() {
        //given
        String data = "1,2";

        //when
        String[] split = data.split(",");

        //then
        assertThat(split).contains("1");
        assertThat(split).contains("2");
    }
    
    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    public void split_containsExactly() {
        //given
        String data = "1";

        //when
        String[] split = data.split(",");

        //then
        assertThat(split).containsExactly("1");
    }
    
    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    public void substring() {
        //given
        String data = "(1,2)";

        //when
        String substring = data.substring(1, 4);

        //then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    public void charAt(){
        //given
        String data = "abc";

        //when
        char c = data.charAt(2);

        //then
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    public void charAt_exception(){
        //given
        String data = "abc";

        //when
        int index = 3;

        //then
        assertThatThrownBy(() -> {
            data.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
