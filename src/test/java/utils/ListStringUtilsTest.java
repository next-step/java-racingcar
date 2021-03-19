package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListStringUtilsTest {

    @DisplayName("ListStringUtils 클래스 Null 검증 여부 테스트")
    @Test
    void Null_검증() {
        // given
        List<String> strings = null;

        // when
        assertThat(ListStringUtils.isNull(strings)).isTrue();
    }

    @DisplayName("ListStringUtils 클래스 사이즈 0인지 검증 여부 테스트")
    @Test
    void 사이즈_0_검증() {
        // given
        List<String> strings = new ArrayList<>();

        // when
        assertThat(ListStringUtils.isSizeZero(strings)).isTrue();
    }

    @DisplayName("ListStringUtils 클래스 사이즈 0인지 검증 여부 테스트")
    @Test
    void Null_또는_사이즈_0__검증() {
        // given
        List<String> strings = new ArrayList<>();

        // when
        assertThat(ListStringUtils.isNullOrSizeZero(strings)).isTrue();
    }
}
