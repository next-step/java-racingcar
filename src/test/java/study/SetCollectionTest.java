package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>(Arrays.asList(1,1,2,3));
    }

    @DisplayName("java.util.Set의 size()메소드 동작 테스트")
    @Test
    void sizeTest() {

        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("java.util.Set의 contaions() 메소드 true 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTestWithValidElements(int number) {

        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("java.util.Set의 contaions() 메소드 true/false 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false", "6:false"}, delimiter = ':')
    void containsTestWithElements(int number, boolean expected){

        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
