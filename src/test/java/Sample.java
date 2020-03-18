import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Sample {

    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    @Test
    public void split() {
        String target = "1,2";
        String[] tokens = target.split(",");
        assertThat(tokens).containsExactly("1", "2");
    }

    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
    @Test
    public void splitSingleToken() {
        String target = "1";
        String[] tokens = target.split(",");
        assertThat(tokens).containsExactly("1");
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
    @Test
    public void substring() {
        String target = "(1,2)";
        String result = target.substring(1, target.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    @Test
    public void charAt() {
        final String target = "abc";
        char result = target.charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @DisplayName("StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트")
    @Test
    public void charAtThrowsException() {
        final String target = "abc";

        assertThatThrownBy(() -> {
            target.charAt(5);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
