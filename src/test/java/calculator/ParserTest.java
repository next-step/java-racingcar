package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class ParserTest {

    private Parser parser;

    @BeforeEach
    void setUp() {
        parser = new Parser();
    }

    @Test
    @DisplayName("[1] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리")
    public void parseTest1() {
        String given = "1:2,3";
        List<String> actual = parser.parse(given);
        assertThat(actual).contains("1");
        assertThat(actual).contains("2");
        assertThat(actual).contains("3");
    }

    @Test
    @DisplayName("[1] 숫자 하나만 전달하면 해당 숫자만 담은 리스트 반환")
    public void parseTest2() {
        String given = "1";
        List<String> actual = parser.parse(given);
        assertThat(actual).contains("1");
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    @DisplayName("[1] 빈 문자열을 전달하면 빈 리스트 반환")
    public void parseTest3(String given) {
        List<String> actual = parser.parse(given);
        assertThat(actual).isEmpty();
    }

    @Test
    @DisplayName("[1] null을 전달하면 빈 리스트 반환")
    public void parseTest4() {
        String given = null;
        List<String> actual = parser.parse(given);
        assertThat(actual).isEmpty();
    }

    @Test
    @DisplayName("[4] 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있음 (“//”와 “\\n” 사이에 위치)")
    public void parseTest5() {
        String given = "//;\\n1;2;3";
        List<String> actual = parser.parse(given);
        assertThat(actual).contains("1");
        assertThat(actual).contains("2");
        assertThat(actual).contains("3");
    }
}
