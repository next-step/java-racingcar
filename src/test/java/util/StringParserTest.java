package util;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParserTest {
    @Test
    public void split_default_character() {
        List<String> strs = StringParser.split("daniel, ziont, tom");

        assertThat(strs).hasSize(3);
        assertThat(strs).contains("daniel", "ziont", "tom");
    }
}
