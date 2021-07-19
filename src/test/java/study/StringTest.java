package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String delimiter = ",";
        assertThat("1,2".split(delimiter)).containsExactly("1", "2");
        assertThat("1".split(delimiter)).containsExactly("1");
    }

    @Test
    void substring() {
        String given = "(1,2)";
        String actual = given.substring(1, given.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt accesses out of bounds index")
    void charAt() {
        assertThatThrownBy(() -> "abc".charAt(5)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
