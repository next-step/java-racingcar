package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterRegexTest {

    @Test
    public void 생성_테스트() {
        SplitterRegex splitterRegex = new SplitterRegex("a","b");
        assertThat(splitterRegex.get()).isEqualTo("[ab]");
    }

    @Test
    public void 공백_생성_테스트(){
        SplitterRegex splitterRegex = new SplitterRegex();
        assertThat(splitterRegex.get()).isEqualTo("[]");
    }

}
