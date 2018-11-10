package calculator2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringNumberParserTest {

    @Test
    public void 파싱() throws Exception {
        String text = "1,2;3";
        String[] texts = StringNumberParser.parse(text);
        assertThat(texts).contains("1", "2", "3");
    }

    @Test
    public void 파싱_null_또는_빈문자() throws Exception {
        assertThat(StringNumberParser.parse("")).contains("0");
        assertThat(StringNumberParser.parse(null)).contains("0");
    }

    @Test
    public void 파싱_커스텀_구분자() throws Exception {
        assertThat(StringNumberParser.parse("//;\n1;2;3")).contains("1", "2", "3");
    }
}
