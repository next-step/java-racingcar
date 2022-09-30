package utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringUtilsTest {
    @Test
    void nullIsEmpty() {
        assertThat(StringUtils.isEmpty(null)).isTrue();
    }

    @Test
    void emptyStringIsEmpty() {
        assertThat(StringUtils.isEmpty("")).isTrue();
    }

    @Test
    void stringIsNotEmpty() {
        assertThat(StringUtils.isEmpty("a")).isFalse();
    }

    @Test
    void convertStringListToIntegerList() {
        List<String> stringList = Arrays.asList("-1", "2", "3");
        assertThat(StringUtils.convertStringListToIntegerList(stringList)).isEqualTo(Arrays.asList(-1, 2, 3));
    }

    @Test
    void convertStringListToIntegerListInvalidStringList() {
        List<String> invalidStringList = Arrays.asList("a", "b", "c");
        assertThatThrownBy(() -> StringUtils.convertStringListToIntegerList(invalidStringList))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void convertStringListToPositiveIntegerList() {
        List<String> stringList = Arrays.asList("1", "2", "3");
        assertThat(StringUtils.convertStringListToPositiveIntegerList(stringList)).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void convertStringListToPositiveIntegerListNegativeInteger() {
        List<String> invalidStringList = Arrays.asList("-1", "2", "3");
        assertThatThrownBy(() -> StringUtils.convertStringListToPositiveIntegerList(invalidStringList))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Negative Number is Invalid");
    }
}
