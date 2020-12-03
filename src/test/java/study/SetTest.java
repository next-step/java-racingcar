package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @Test
    @DisplayName("Set 클래스의 size 테스트")
    public void size() throws Exception {
        //Given

        //When
        int size = numbers.size();

        //Then
        assertThat(size).isEqualTo(3);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set 클래스의 contains 테스트")
    public void contains(int input) throws Exception {
        assertThat(numbers.contains(input)).isTrue();

    }


    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true","4:false","5:false"}, delimiter = ':')
    @DisplayName("Set 클래스의 contains 성공 및 실패 테스트")
    void contain_test_with_true_and_false_cases(int input, boolean expected) {
        assertEquals(numbers.contains(input), expected);
    }

}
