package lotto;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TextTest {

    private static final String[] DUMMY_SPLITTER = {","};

    @Test
    public void 텍스트생성_잘못된경우() {
        assertThatThrownBy(() -> {
            new Text(null, DUMMY_SPLITTER);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            new Text("", DUMMY_SPLITTER);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            new Text("              ", DUMMY_SPLITTER);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 텍스트스_값_확인() {
        Text text = new Text("1,2,3,4,5", DUMMY_SPLITTER);
        List<String> result = text.getValues().getValues();
        assertThat(result.get(0)).isEqualTo("1");
        assertThat(result.get(1)).isEqualTo("2");
        assertThat(result.get(2)).isEqualTo("3");
        assertThat(result.get(3)).isEqualTo("4");
        assertThat(result.get(4)).isEqualTo("5");
    }

    @Test
    public void 텍스트_값_확인_커스텀_글자() {
        Text text = new Text("//c\n1,2,3,4,5", DUMMY_SPLITTER);
        List<String> result = text.getValues().getValues();
        assertThat(result.get(0)).isEqualTo("1");
        assertThat(result.get(1)).isEqualTo("2");
        assertThat(result.get(2)).isEqualTo("3");
        assertThat(result.get(3)).isEqualTo("4");
        assertThat(result.get(4)).isEqualTo("5");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "//c\t1,2,3",
            "//c\n2,2'",
            "1,2,3,a",
            "//c\n2c2c2b",
            "",
            "123.1"
    })
    public void 텍스트_값_잘못된경우(String input) {
        assertThatThrownBy(() -> {
            new Text(input, DUMMY_SPLITTER);
        }).isInstanceOf(RuntimeException.class);
    }


}
