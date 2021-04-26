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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StringTest {

    @Test
    void split() {
        final String[] actual = "1,2".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void splitString() {
        final String actual1 = "(1,2)";
        actual1.replace("(", "");
        actual1.replace(")", "");
        assertThat(actual1).contains("1,2");
    }

    @Test
    @DisplayName("assertThatThrownBy")
    void indexOf () {
        String testIndex = "124566334s";
        assertThatThrownBy(() -> {
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("Index:2, Size:2");
        int resultIndex = index(testIndex);
        assertEquals(1, resultIndex);
    }

    @Test
    void exceptionIndex() {
        assertThatThrownBy(() -> {
        }).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("Index:2, Size:2");
    }

    private int index(String string) {
        String abc = "abc";
        int resultIndex = abc.indexOf(string);
        return resultIndex;
    }

    /*--------------Set study---------------------------------------------------------------------------------------------------------------*/
    private Set<Integer> numbers;

    @Test
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        int set_size = numbers.size();
        assertEquals(3, set_size);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void parameterizedTest(int input) {
        assertTrue(numbers.contains(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"true:false", "4:false", "5:false"}, delimiter = ':')
    void parameterizedTest(String input,String expected) {
        boolean value = numbers.contains(input);
        assertEquals(false,value);
    }

}
