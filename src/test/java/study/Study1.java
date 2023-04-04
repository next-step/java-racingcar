package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Study1 {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void splitTest() {
        String str = "1,2";
        String[] result = str.split(",");

        assertThat(result).contains("1","2");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void subString() {
        String str = "(1,2)";
        String result = str.substring(1, str.length() -1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException Test")
    void test() {
        String str = "abc";

        assertThatThrownBy(() -> {
            str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 3");
    }

    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void SetCollectionTest_1(Integer number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void SetCollectionTest_2(String input, String expected) {
        Integer actual = Integer.parseInt(input);
        Boolean result = Boolean.parseBoolean(expected);
        assertThat(numbers.contains(actual)).isEqualTo(result);
    }
}
