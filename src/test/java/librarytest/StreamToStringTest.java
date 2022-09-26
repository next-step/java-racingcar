package librarytest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class StreamToStringTest {

    @Test
    @DisplayName("스트림 toString")
    void stream_to_string() {
        //given
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        //when
        String toStringText = strings.toString();
        //then
        assertThat(toStringText).isEqualTo("[a, b]");
    }

    @Test
    @DisplayName("스트림 toString 하고 [] 잘라내기")
    void stream_to_string_remove_bracket() {
        //given
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        //when
        String toStringText = strings.stream().collect(Collectors.joining(","));
        System.out.println(toStringText);
        //then
        assertThat(toStringText).isEqualTo("a,b");
    }
}
