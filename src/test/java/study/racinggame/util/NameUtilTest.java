package study.racinggame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NameUtilTest {
    @Test
    @DisplayName("컴마(,)로 구분된 자동차의 이름 문자열을 List로 반환")
    void 컴마로_구분된_자동차의_이름_문자열을_List로_반환() {
        List<String> expected = List.of("푸바오", "아이바오", "러바오");
        List<String> actual = NameUtil.convertToList("푸바오,아이바오,러바오");
        assertThat(actual).hasToString(String.valueOf(expected));
    }
}