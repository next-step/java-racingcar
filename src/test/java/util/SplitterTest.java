package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class SplitterTest {

    @DisplayName("사용자의 입력에서 공백을 기준으로 쪼개서 반환한다")
    @Test
    void split() {
        //given
        String input = "2 + 3 / 1";
        List<String> expected = Arrays.asList("2", "+", "3", "/", "1");

        //when
        List<String> operations = Splitter.split(input);

        //then
        assertThat(operations).isEqualTo(expected);
    }
}
