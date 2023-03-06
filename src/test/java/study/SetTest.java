package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현

    //Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
    @ParameterizedTest
    void size() {
        assertThat(numbers.contains(123));
    }

    @ValueSource(ints = {1,2,3})
    @ParameterizedTest
    void Contains(final int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

}
