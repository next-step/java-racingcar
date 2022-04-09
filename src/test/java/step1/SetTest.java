package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

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
    @DisplayName("set size 테스트")
    void size_test(){
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest()
    @DisplayName("set contains 테스트")
    @ValueSource(ints = {1, 2, 3})
    void contains_true_test(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("set contains 테스트")
    @CsvSource(
            value = {
                    "1:true",
                    "2:true",
                    "3:true",
                    "4:false",
                    "5:false"
            },
            delimiter = ':')
    void contains_test(int value, boolean res){
        assertThat(numbers.contains(value)).isEqualTo(res);
    }

}
