package racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringUtilTest {

    @Test
    void splitStringToList() {
        String str1 = "nimoh";
        String delimiter1 = ",";

        String str2 = "nimoh: pobi";
        String delimiter2 = ":";

        String str3 = "nimoh   ;   pobi;   speed";
        String delimiter3 = ";";

        assertThat(StringUtil.splitStringToList(str1, delimiter1)).containsExactly("nimoh");
        assertThat(StringUtil.splitStringToList(str2, delimiter2)).containsExactly("nimoh", "pobi");
        assertThat(StringUtil.splitStringToList(str3, delimiter3)).containsExactly("nimoh", "pobi", "speed");
    }
}