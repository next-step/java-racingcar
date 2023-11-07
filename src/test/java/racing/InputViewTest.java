package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    void String_분리() {
        String inputNames = "a,b,c";
        String[] names = inputNames.split(",");
        assertThat(names[0]).isEqualTo("a");
    }
}