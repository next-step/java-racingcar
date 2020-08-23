import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {

    // [requirement 1]
    // "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인
    @Test
    void split() {
        String[] result2 = "1,2".split(",");
        assertThat(result2).containsExactly("1", "2");
    }

    // [requirement 2]
    // "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해
    // ()을 제거하고 "1,2"를 반환하도록 구현한다.
    @Test
    void extractNumbers() {
        String target = "(1,2)";
        String result = target.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }
}
