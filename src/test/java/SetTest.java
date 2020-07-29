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

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        //HashSet stores unique value, it means even Arrays.asList() has two 1 integer value,
        //but numbers set has only one value. Please check request1 test case.
        //https://stackoverflow.com/questions/12940663/does-adding-a-duplicate-value-to-a-hashset-hashmap-replace-the-previous-value
        numbers = new HashSet<>(Arrays.asList(1, 1, 2, 3));
    }

    @Test
    @DisplayName("Case1: Check a set's size using Method")
    void request1() {
        assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("Case2: Check a value existence in a set.")
    void request2() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers).contains(2);
        assertThat(numbers.contains(3)).isTrue();
    }

    // DO NOT USE @Test if I decide to use @ParameterizedTest annotation.
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Case3: Check a value existence in a set using ParameterizedTest annotation.")
    void request2_1(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    // Check the comment if I want to use a default delimiter.
    // The default delimiter is character ,
    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    //@CsvSource(value = {"1,true","2,true","3,true","4,false","5,false"})
    @DisplayName("Case4: Using CsvSource annotation for check whether a specific value contains.")
    void request3(int value, boolean expected){
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }
}
