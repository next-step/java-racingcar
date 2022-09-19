import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {
    @Test
    void 문자열을_쪼깬_배열은_쪼개진_요소들은_포함한다() {
        String str = "1,2";
        String[] sut = str.split(",");
        assertThat(sut).containsExactly("1", "2");
    }

    @Test
    void 문자열을_쪼깰_때_쪼깬_요소들을_포함한_배열이_반환된다() {
        String str = "1";
        String[] sut = str.split(",");
        assertThat(sut).isEqualTo(new String[]{"1"});
    }

    @Test
    void 문자열을_부분적으로_추출할_수_있다() {
        String str = "(1,2)";
        String sut = str.substring(1, 4);
        assertThat(sut).isEqualTo("1,2");
    }
}
