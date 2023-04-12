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

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("1단계_SetCollectionTest_요구사항1 - size() 했을 때 Set 의 크기인 3이 반환되는지 확인")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("1단계_SetCollectionTest_요구사항2 - contains() 했을 때 1, 2, 3의 값이 존재하는지를 확인")
    @ParameterizedTest(name = "testValue : {0}")
    @ValueSource(ints = {1, 2, 3})
    void contains_only_true_case(int number) {
        assertThat(numbers).contains(number);
    }

    @DisplayName("1단계_SetCollectionTest_요구사항3 - contains() 했을 때 1, 2, 3의 값은 존재하고, 4, 5의 값은 존재하지 않음을 확인")
    @ParameterizedTest(name = "testValue : {0}, 포함여부 : {1}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_true_and_false_case(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
