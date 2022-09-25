package librarytest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitTest {
    @Test
    @DisplayName(",,,을 split하면 길이가 0 ")
    void split_only_comma() {
        String[] split = ",,,".split(",");
        assertThat(split).isEmpty();
    }

    @Test
    @DisplayName(", ,,을 split하면 길이가 2")
    void split_only_comma_and_blank1() {
        String[] split = ", ,,".split(",");
        assertThat(split).hasSize(2);
    }

    @Test
    @DisplayName(", , ,을 split하면 길이가 3")
    void split_only_comma_and_blank2() {
        String[] split = ", , ,".split(",");
        assertThat(split).hasSize(3);
    }

    @Test
    @DisplayName(",, ,을 split하면 길이가 3")
    void split_only_comma_and_blank3() {
        String[] split = ",, ,".split(",");
        assertThat(split).hasSize(3);
    }

    @Test
    @DisplayName(" , , ,을 split하면 길이가 4")
    void split_only_comma_and_blank4() {
        String[] split = " , , ,".split(",");
        assertThat(split).hasSize(3);
    }

}
