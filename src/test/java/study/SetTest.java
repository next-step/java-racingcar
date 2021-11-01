package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
    @DisplayName("Set 은 중복을 허용하지 않는다.")
    void setTest() throws Exception {
        assertThat(numbers.size()).isEqualTo(3);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int element) throws Exception {
        assertThat(numbers.contains(element)).isTrue();
    }


}
