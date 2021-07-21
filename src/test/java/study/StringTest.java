package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("요구사항1.1: '1,2'를 split하면 1과 2를 리턴한다.")
    void split_return_two_digits() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1","2");
    }

    @Test
    @DisplayName("요구사항 1.2: '1'을 split하면 1만 리턴한다.")
    void split_return_one_digit() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }


    @Test
    @DisplayName("요구사항 2: '(1,2)'에서 substring으로 ()을 제거, 1,2를 반환한다.")
    void substring_remove_parenthesis() {
        String input = "(1,2)";
        String result = "(1,2)".substring(1, input.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3: charAt에서 IndexOutOfBoundException을 발생시킨다.")
    void charAt_IndexOutOfBoundException_test() {
        assertThatThrownBy(() -> { "abc".charAt(3); }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
