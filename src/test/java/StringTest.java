
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @DisplayName("'1,2'을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트 구현")
    @Test
    void split_메소드_학습테스트() {
        String[] actual = "1,2".split(",");

        assertThat(actual).contains("1","2");
        assertThat(actual).containsExactly("1","2");
    }

    @DisplayName("'1'을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트 구현")
    @Test
    void split_메소드_학습테스트_2() {
        String[] actual = "1".split(",");

        assertThat(actual).contains("1");
        assertThat(actual).containsExactly("1");
    }

    @DisplayName("'(1,2)' 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환하는지에 대한 학습 테스트 구현")
    @Test
    void substring_메소드_학습테스트() {
        String actual = "(1,2)".substring(1, 4);

        assertThat(actual).isEqualTo("1,2");
    }

    @DisplayName("'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트 구현")
    @Test
    void charAt_메소드_학습테스트() {
        char actual = "abc".charAt(1);

        assertThat(actual).isEqualTo('b');
    }

    @DisplayName("인덱스를 벗어났을때, indexoutofbound 예외가 발생하는 학습 테스트 구현")
    @Test
    void charAt_메소드_학습테스트_2() {
        assertThatThrownBy(() -> {
            char actual = "abc".charAt(100);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }



}