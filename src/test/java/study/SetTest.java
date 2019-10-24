package study;

import org.assertj.core.internal.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {

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
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})  //JUnit5 추가 기능
    void contains(int no) {
        assertThat(numbers.contains(no)).isTrue();

    }

/*
    @ParameterizedTest
    @CsvFileSource(value = {"1:true", "4:false"}, delimiter=':')  //JUnit5 추가 기능
    void contains2(int no, boolean result) {
        assertThat(numbers.contains(no)).isEqualTo(result);

    }
*/

}
