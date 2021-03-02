package study;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @Test
    @DisplayName("요구사항 1-1 : 1과 2로 잘 분리되는지 확인.")
    void splitByComma() {
        String data[] = "1,2".split(",");
        assertThat(data).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항 1-2 : 1만을 포함하는 배열이 반환되는지 확인.")
    void splitOnlyOne() {
        String data[] = "1".split(",");
        assertThat(data).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항 2 : ()을 제거하고 반환하는지 확인.")
    void splitExceptBracket() {
        String data = "(1,2)";
        String result = data.substring(1, data.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3 : 특정 위치의 문자를 가져온다.")
    void getCharByIndex() {
        char data = "abc".charAt(1);
        assertThat(data).isEqualTo('b');
    }

    @Test
    @DisplayName("요구사항 3 : 위치 값을 벗어나면 인덱스 아웃 에러가 발생한다.")
    void getCharByIndexOut() {
        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }


}
