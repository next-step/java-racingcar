package racing.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SplitUtilTest {

    @Test
    void 리스트_문자_변환() {
        List<String> list = Arrays.asList("자동차1", "자동차2");
        assertThat(SplitUtil.listToStr(list)).isEqualTo("자동차1,자동차2");
    }

    @Test
    void Null_체크() {
        List<String> list = new ArrayList<>();
        assertThat(SplitUtil.listToStr(list)).isBlank();
    }

    @Test
    void 문자_리스트_변환() {
        String str = "자동차1,자동차2";
        assertThat(SplitUtil.strToList(str)).isEqualTo(Arrays.asList("자동차1", "자동차2"));
    }
}