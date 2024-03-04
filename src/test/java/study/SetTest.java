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
    void sizeOfSet(){
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("중복 코드 합쳐 test 하기")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsEachElement(int element) {
        assertThat(numbers.contains(element)).isTrue();
    }

    @DisplayName("중복 코드 합쳐 다양한 결과 test 하기")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsEachElementUsingCsv(int element, boolean expected) {
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }


}
